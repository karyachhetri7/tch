package com.example.tch.repository.spec;

import com.example.tch.model.BankDetail;
import com.example.tch.model.spec.SearchCriteria;
import com.example.tch.model.spec.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BankDetailSpecification implements Specification<BankDetail> {

    private static final Map<SearchOperation, PredicateBuilder<BankDetail>> SEARCH_OPERATION_PREDICATE_MAP = Map.of(
            SearchOperation.EQUAL,
            (Root<BankDetail> root, SearchCriteria criteria, CriteriaBuilder criteriaBuilder) ->
                    criteriaBuilder.equal(
                            root.get(criteria.getKey().name), criteria.getValue())
    );
    private final List<SearchCriteria> searchCriteriaList = new ArrayList<>();

    public BankDetailSpecification(SearchCriteria... searchCriteriaList) {
        Arrays.stream(searchCriteriaList).forEach(this.searchCriteriaList::add);
    }

    @Override
    public Predicate toPredicate(Root<BankDetail> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        searchCriteriaList
                .stream()
                .map(criteria ->
                        SEARCH_OPERATION_PREDICATE_MAP.get(criteria.getOperation())
                                .build(root, criteria, criteriaBuilder))
                .forEach(predicates::add);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
