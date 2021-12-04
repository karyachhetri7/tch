package com.example.tch.repository.spec;

import com.example.tch.model.spec.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@FunctionalInterface
public interface PredicateBuilder<T> {

    Predicate build(Root<T> root, SearchCriteria criteria, CriteriaBuilder criteriaBuilder);
}
