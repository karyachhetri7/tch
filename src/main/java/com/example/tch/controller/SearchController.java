package com.example.tch.controller;

import com.example.tch.model.BankDetail;
import com.example.tch.model.SearchRequest;
import com.example.tch.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/content/search-requests/v1")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public List<BankDetail> search(@Valid @RequestBody List<SearchRequest> searchRequests) {
        log.info("SearchController::search {}", searchRequests);

        return this.searchService.search(searchRequests);
    }
}
