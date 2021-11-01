package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "tag")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagEntity extends BaseEntity {

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

}
