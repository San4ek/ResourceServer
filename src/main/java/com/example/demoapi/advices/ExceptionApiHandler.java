package com.example.demoapi.advices;

import com.example.demoapi.exceptions.NoAnyContentException;
import com.example.demoapi.exceptions.NotFoundException;
import com.example.demoapi.models.ErrorResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionApiHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse onNotFoundException(NotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoAnyContentException.class)
    public ErrorResponse onNoAnyContentException(NoAnyContentException e) {
        log.error(e.getMessage());
        return new ErrorResponse(e.getMessage());
    }
}
