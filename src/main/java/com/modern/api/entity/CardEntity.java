package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import com.opw.modern.api.model.Order;
import com.opw.modern.api.model.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "EXPIRES")
    private String expires;

    @Column(name = "CVV")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity user;

    @OneToMany(mappedBy = "cardEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<OrderEntity> orders;


}
