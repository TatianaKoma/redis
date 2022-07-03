package com.example.redis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersoneNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7428051251365675318L;

    public PersoneNotFoundException(String message) {
        super(message);
    }
}
