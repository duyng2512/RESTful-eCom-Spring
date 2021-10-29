package com.modern.api.entity;

import com.modern.api.entity.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "tab")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagEntity extends BaseEntity {

    @NotNull
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

}
