package com.example.tch.model.spec;

import com.example.tch.model.State;
import com.example.tch.model.Type;

import java.util.function.Function;

public enum Key {
    ZIP_CODE("zipCode", Integer::valueOf),
    STATE("state", State::valueOf),
    CITY("city", c -> c),
    TYPE("type", Type::valueOf),
    BANK_NAME("bankName", b -> b);

    public final String name;
    public final Function<String, Object> mapper;

    Key(String name, Function<String, Object> mapper) {
        this.name = name;
        this.mapper = mapper;
    }
}
