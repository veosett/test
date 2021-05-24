package com.example.quote.controller;

import com.example.quote.validator.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
/**
    TODO add java docs
 */
@ControllerAdvice
class ControllerAdviceErrorHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationFailedResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationFailedResponse error = new ValidationFailedResponse();
        for (ObjectError err : e.getBindingResult().getAllErrors()) {
            error.getViolations().add(new ViolationErrors(err.getDefaultMessage()));
        }
        return error;
    }
}
