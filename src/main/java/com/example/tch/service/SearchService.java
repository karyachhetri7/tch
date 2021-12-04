package com.example.tch.service;

import com.example.tch.model.BankDetail;
import com.example.tch.model.SearchCondition;
import com.example.tch.model.SearchRequest;
import com.example.tch.repository.BankDetailRepository;
import com.example.tch.repository.spec.BankDetailSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SearchService {

    private final BankDetailRepository repository;

    @Autowired
    public SearchService(BankDetailRepository repository) {
        this.repository = repository;
    }

    public List<BankDetail> search(List<SearchRequest> searchRequests) {

        List<BankDetailSpecification> specs = searchRequests.stream()
                .map(SearchRequest::getSearchCriteria)
                .map(BankDetailSpecification::new)
                .collect(Collectors.toList());

        Specification baseSpec = specs.get(0);
        SearchCondition condition = searchRequests.get(0).getCondition();
        for (int i = 1; i < searchRequests.size(); i++) {
            baseSpec = condition.specOperator.apply(baseSpec, specs.get(i));
            condition = searchRequests.get(i).getCondition();
        }

        return this.repository.findAll(baseSpec);
    }
}
