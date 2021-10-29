package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "shipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentEntity extends BaseEntity {

    @Column(name = "CARRIER")
    private String carrier;

    @Column(name = "EST_DELIVERY_DATE")
    private Timestamp estDeliveryDate;

    @OneToOne(mappedBy = "shipmentEntity")
    private OrderEntity orderEntity;

}
