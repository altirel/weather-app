package com.basiliqo.weatherappbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorDetails> handleHttpClientErrorException() {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),
                "Error occurred while processing a request to Open Weather API");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
