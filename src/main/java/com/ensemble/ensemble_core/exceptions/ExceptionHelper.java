package com.ensemble.ensemble_core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionHelper extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private String status;
    private String statusMessage;

    @ExceptionHandler(value = { HttpClientErrorException.Unauthorized.class })
    public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        logger.error("Unauthorized Exception: {}",ex.getMessage());
        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex) {
        logger.error("Exception: {}",ex.getMessage());
        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}