package com.modern.api.repository;

import com.modern.api.entity.OrderEntity;
import com.opw.modern.api.model.NewOrder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}

