package com.fernando.oliveira.traveler.domain.builder;

import com.fernando.oliveira.traveler.domain.response.ExceptionResponse;
import com.fernando.oliveira.traveler.exception.TravelerException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExceptionResponseBuilder {

    public ExceptionResponse getBusinessException(TravelerException exception){
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .build();
    }
}
