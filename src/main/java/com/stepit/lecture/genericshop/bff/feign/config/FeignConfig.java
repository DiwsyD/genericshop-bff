package com.stepit.lecture.genericshop.bff.feign.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepit.lecture.genericshop.bff.feign.decoder.CustomFeignErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class FeignConfig {

    @Bean
    public CustomFeignErrorDecoder customFeignErrorResponseDecoder(ObjectMapper objectMapper) {
        return new CustomFeignErrorDecoder(objectMapper);
    }

}
