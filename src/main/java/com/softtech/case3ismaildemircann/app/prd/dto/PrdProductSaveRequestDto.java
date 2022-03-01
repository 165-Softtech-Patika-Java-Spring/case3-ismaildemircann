package com.softtech.case3ismaildemircann.app.prd.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PrdProductSaveRequestDto {

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

}
