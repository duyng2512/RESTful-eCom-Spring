package com.modern.api.service.impl;

import com.modern.api.entity.ProductEntity;
import com.modern.api.repository.ProductRepository;
import com.modern.api.service.inf.ProductService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProduct(String id) {
        return repository
                .findById(UUID.fromString(id));
    }
}
