package com.softtech.case3ismaildemircann.app.gen.exceptions;

import com.softtech.case3ismaildemircann.app.gen.enums.BaseErrorMessage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class GenBusinessException extends RuntimeException{

    @NonNull
    private BaseErrorMessage baseErrorMessage;
}