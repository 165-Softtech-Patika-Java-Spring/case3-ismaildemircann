package com.softtech.case3ismaildemircann.app.usr.enums;

import com.softtech.case3ismaildemircann.app.gen.enums.BaseErrorMessage;

public enum UsrErrorMessage implements BaseErrorMessage {

    USER_NOT_FOUND_MESSAGE("User not found!"),
    USER_USERNAME_EXIST_MESSAGE("Username is already exist!"),
    USER_EMAIL_EXIST_MESSAGE("E-mail is already exist!"),
    USER_PHONE_NUMBER_EXIST_MESSAGE("Phone number is already exist!")
    ;

    private String message;

    UsrErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}