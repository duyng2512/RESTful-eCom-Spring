package com.modern.api.repository;

import com.modern.api.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentEntity, UUID> {



}
