package com.kaja.shop.controller;

import org.hibernate.StaleObjectStateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFound(EntityNotFoundException e) {

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(StaleObjectStateException.class)
    public void handleStaleObjectStateException(StaleObjectStateException e) {

    }
}
