package com.example.tch.model;

import com.example.tch.model.spec.SearchCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
final public class SearchRequest {

    @NotNull
    private SearchCriteria searchCriteria;
    private SearchCondition condition;

}
