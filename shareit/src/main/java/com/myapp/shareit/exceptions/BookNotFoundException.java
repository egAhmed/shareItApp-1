package com.myapp.shareit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
