package com.myapp.shareit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
