package com.example.kingdom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WarriorNotFoundExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(WarriorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String WarriorNotFoundHandler (WarriorNotFoundException e) {
        return e.getMessage();
    }
}
