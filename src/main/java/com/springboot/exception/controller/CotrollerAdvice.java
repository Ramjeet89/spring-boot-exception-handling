package com.springboot.exception.controller;

import com.springboot.exception.exception.OrderServiceException;
import com.springboot.exception.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CotrollerAdvice {

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mapException(OrderServiceException ex) {
        OrderError orderError = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(orderError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
