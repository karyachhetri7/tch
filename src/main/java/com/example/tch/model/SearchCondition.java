package com.example.tch.model;

import org.springframework.data.jpa.domain.Specification;

import java.util.function.BinaryOperator;

public enum SearchCondition {
    AND((spec1, spec2) -> spec1.and(spec2)), OR((spec1, spec2) -> spec1.or(spec2));

    public final BinaryOperator<Specification> specOperator;

    SearchCondition(BinaryOperator<Specification> specOperator) {
        this.specOperator = specOperator;
    }
}
