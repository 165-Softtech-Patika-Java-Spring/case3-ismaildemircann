package com.softtech.case3ismaildemircann.app.usr.dto;

import com.softtech.case3ismaildemircann.app.usr.enums.UsrUserType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UsrUserSaveRequestDto {

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Long phoneNumber;

    @NotNull
    private UsrUserType userType;

}
