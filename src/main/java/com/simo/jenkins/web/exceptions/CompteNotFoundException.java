package com.simo.jenkins.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompteNotFoundException extends RuntimeException {


    public CompteNotFoundException(String message) {
        super(message);
    }
}

