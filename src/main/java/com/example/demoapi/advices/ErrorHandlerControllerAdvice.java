package com.example.demoapi.advices;

import com.example.demoapi.models.ValidationErrorResponse;
import com.example.demoapi.models.Violation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        final List<Violation> violations=e.getConstraintViolations().stream().
                map(violation -> new Violation(violation.getPropertyPath().toString(), violation.getMessage())).toList();
        log.error(e.getMessage());

        return new ValidationErrorResponse(violations);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onMethodArgumentNoValidException(MethodArgumentNotValidException e) {
        final List<Violation> violations=e.getBindingResult().getFieldErrors().stream().
                map(error -> new Violation(error.getField(), error.getDefaultMessage())).toList();
        log.error(e.getMessage());

        return new ValidationErrorResponse(violations);
    }
}
