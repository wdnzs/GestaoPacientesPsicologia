package com.diniz.gestaopacientesapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.diniz.gestaopacientesapi.exception.RecordNotFoundException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public String handelNotFoundException(RecordNotFoundException ex){
        return ex.getMessage();
    }
}
