package com.stepit.lecture.genericshop.exception.custom;

import com.stepit.lecture.genericshop.exception.response.ErrorResponse;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final String type = "Internal Microservice Exception.";
    private final ErrorResponse errorResponse;

    public ServiceException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

}
