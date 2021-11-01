package com.modern.api.repository;


import com.modern.api.entity.ShipmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShipmentRepository extends PagingAndSortingRepository<ShipmentEntity, UUID> {
}
