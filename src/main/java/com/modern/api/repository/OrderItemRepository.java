package com.modern.api.repository;

import com.modern.api.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItemEntity, UUID> {
}
