package org.moveApp.controller;

import org.moveApp.exception.ResourceNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BeerControllerAdvice extends Throwable {

    @ExceptionHandler({ResourceNotFound.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request) {

        return new ResponseEntity<Object>("Resource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}

