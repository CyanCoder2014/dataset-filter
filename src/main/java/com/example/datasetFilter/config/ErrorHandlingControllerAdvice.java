package com.example.datasetFilter.config;


import com.example.datasetFilter.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleGeneralException(Exception exception) {
        ExceptionResponse error = new ExceptionResponse();
        error.setCode(500);
        error.setMsg(exception.getMessage());
        return error;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequestExceptions(BadRequestException ex) {
        ExceptionResponse error = new ExceptionResponse();
        error.setCode(ex.getCode());
        error.setMsg(ex.getMessage());
        return error;
    }



}


