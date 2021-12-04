package com.example.tch.model.spec;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
final public class SearchCriteria {
    private final Key key;
    private final SearchOperation operation;
    private final Object value;

    public SearchCriteria(Key key, SearchOperation operation, Object value) {
        this.key = key;
        this.value = key.mapper.apply(value.toString());
        this.operation = operation;
    }
}
