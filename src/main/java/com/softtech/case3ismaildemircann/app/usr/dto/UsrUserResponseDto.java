package com.softtech.case3ismaildemircann.app.usr.dto;

import com.softtech.case3ismaildemircann.app.usr.enums.UsrUserType;
import lombok.Data;

@Data
public class UsrUserResponseDto {

    private Long id;
    private String username;
    private String email;
    private Long phoneNumber;
    private UsrUserType userType;

}
