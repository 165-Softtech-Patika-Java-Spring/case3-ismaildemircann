package com.softtech.case3ismaildemircann.app.prd.enums;

import com.softtech.case3ismaildemircann.app.gen.enums.BaseErrorMessage;

public enum PrdErrorMessage implements BaseErrorMessage {

    PRODUCT_NOT_FOUND_MESSAGE("Product not found!"),
    ;

    private String message;

    PrdErrorMessage(String message) {
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
