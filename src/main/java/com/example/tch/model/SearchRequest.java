package com.example.tch.model;

import com.example.tch.model.spec.SearchCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
final public class SearchRequest {

    private SearchCriteria searchCriteria;
    private SearchCondition condition;

}
