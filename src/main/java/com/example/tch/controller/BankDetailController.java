package com.example.tch.controller;

import com.example.tch.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/content/bank-details/v1")
public class BankDetailController {

    private final UploadService uploadService;

    @Autowired
    public BankDetailController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        log.info("BankDetailController::upload");

        this.uploadService.uploadBankDetail(file);
    }
}
