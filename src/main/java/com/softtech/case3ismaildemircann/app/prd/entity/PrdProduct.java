package com.softtech.case3ismaildemircann.app.prd.entity;

import com.softtech.case3ismaildemircann.app.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRD_PRODUCT")
@Getter
@Setter
public class PrdProduct extends BaseEntity {

    @Id
    @SequenceGenerator(name = "PrdProduct", sequenceName = "PRD_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "PrdProduct")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

}
