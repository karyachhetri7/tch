package com.example.tch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CSVImportException extends RuntimeException {
    private final Class clazz;

    public CSVImportException(Class clazz, String errormessage) {
        super(errormessage);
        this.clazz = clazz;
    }
}
