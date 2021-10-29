package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity extends BaseEntity {

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "RESIDENCY")
    private String residency;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @OneToMany(mappedBy = "addressEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orders;

}
