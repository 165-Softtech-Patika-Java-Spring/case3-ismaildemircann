package com.softtech.case3ismaildemircann.app.cmt.enums;

import com.softtech.case3ismaildemircann.app.gen.enums.BaseErrorMessage;

public enum CmtErrorMessage implements BaseErrorMessage {

    COMMENT_NOT_FOUND_MESSAGE("Comment not found!"),
    ;

    private String message;

    CmtErrorMessage(String message) {
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
