package com.example.tch.service;

import com.example.tch.exception.BadRequestException;
import com.example.tch.exception.CSVImportException;
import com.example.tch.model.BankDetail;
import com.example.tch.repository.BankDetailRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static com.example.tch.util.Preconditions.checkArgument;

@Slf4j
@Service
public class UploadService {

    private final BankDetailRepository repository;

    @Autowired
    public UploadService(BankDetailRepository repository) {
        this.repository = repository;
    }

    public void uploadBankDetail(MultipartFile file) {
        checkArgument(!file.isEmpty(), new BadRequestException("Empty file"));

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<BankDetail> bankDetails = new CsvToBeanBuilder(reader)
                    .withType(BankDetail.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
            log.info(String.valueOf(bankDetails));

            this.repository.saveAll(bankDetails);
        } catch (Exception exception) {
            String errorMessage = "Error during csv import";
            log.error(errorMessage, exception);

            throw new CSVImportException(BankDetail.class, "Error during csv import");
        }
    }

}
