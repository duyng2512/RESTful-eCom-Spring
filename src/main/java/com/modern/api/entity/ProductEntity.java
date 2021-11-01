package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Table(name = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity {

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_TAG",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private List<TagEntity> tagEntity = Collections.emptyList();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ItemEntity> items = Collections.emptyList();



}
