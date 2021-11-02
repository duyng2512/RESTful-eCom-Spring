package com.modern.api.entity.base;

import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Inherited;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    protected UUID id;

}
