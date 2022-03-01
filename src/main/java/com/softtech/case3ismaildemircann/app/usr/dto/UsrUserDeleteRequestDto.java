package com.softtech.case3ismaildemircann.app.usr.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UsrUserDeleteRequestDto {

    @NotNull
    private String username;

    @NotNull
    private Long phoneNumber;

}
