package com.stepit.lecture.genericshop.bff.feign.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepit.lecture.genericshop.exception.custom.ServiceException;
import com.stepit.lecture.genericshop.exception.response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(String s, Response response) {
        ErrorResponse errorResponse;
        try {
            errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ServiceException(errorResponse.getDetails(), errorResponse);
    }
}
