package com.example.tch.repository;

import com.example.tch.model.BankDetail;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BankDetailRepository extends CrudRepository<BankDetail, Long>, JpaSpecificationExecutor<BankDetail> {
}
