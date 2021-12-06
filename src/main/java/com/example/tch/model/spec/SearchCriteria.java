package com.example.tch.model.spec;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
final public class SearchCriteria {
    @NotNull
    private final Key key;
    @NotNull
    private final SearchOperation operation;
    @NotNull
    private final Object value;

    public SearchCriteria(Key key, SearchOperation operation, Object value) {
        this.key = key;
        this.value = key.mapper.apply(value.toString());
        this.operation = operation;
    }
}
