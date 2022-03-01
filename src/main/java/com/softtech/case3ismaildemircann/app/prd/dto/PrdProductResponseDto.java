package com.softtech.case3ismaildemircann.app.prd.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PrdProductResponseDto {

    private Long id;
    private String name;
    private BigDecimal price;

}
