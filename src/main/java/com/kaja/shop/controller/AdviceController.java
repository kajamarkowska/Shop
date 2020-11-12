package com.kaja.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@Slf4j
@ControllerAdvice
@ResponseBody
public class AdviceController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFound(EntityNotFoundException e) {
        log.error(e.getMessage(), e);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(StaleObjectStateException.class)
    public void handleStaleObjectStateException(StaleObjectStateException e) {
        log.error(e.getMessage(), e);
    }


}
