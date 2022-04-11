package com.ua.volunteering.volunteering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class OrderNotNullException extends RuntimeException {

    public OrderNotNullException(Set<Long> id) {
        super("ID = " + id + "not found");
    }
}
