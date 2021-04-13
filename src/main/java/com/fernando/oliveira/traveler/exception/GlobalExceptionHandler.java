package com.fernando.oliveira.traveler.exception;

import com.fernando.oliveira.traveler.domain.builder.ExceptionResponseBuilder;
import com.fernando.oliveira.traveler.domain.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionResponseBuilder responseBuilder;

    @ExceptionHandler(TravelerException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(TravelerException exception){
        ExceptionResponse exceptionResponse = responseBuilder.getBusinessException(exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

}
