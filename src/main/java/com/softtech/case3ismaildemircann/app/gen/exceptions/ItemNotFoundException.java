package com.softtech.case3ismaildemircann.app.gen.exceptions;

import com.softtech.case3ismaildemircann.app.gen.enums.BaseErrorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ItemNotFoundException extends GenBusinessException {

    private String message;

    public ItemNotFoundException(BaseErrorMessage message) {
        super(message);
    }

    public ItemNotFoundException(String message) {
        this.message = message;
    }
}