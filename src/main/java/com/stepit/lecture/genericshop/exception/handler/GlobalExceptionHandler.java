package com.stepit.lecture.genericshop.exception.handler;


import com.stepit.lecture.genericshop.exception.custom.ServiceException;
import com.stepit.lecture.genericshop.exception.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler extends DefaultHandlerExceptionResolver {

    @Value("${views.app.error}")
    private String ERROR_PAGE;

    @ExceptionHandler(ServiceException.class)
    public ModelAndView handleServiceException(HttpServletRequest request, ServiceException exception) {
        ErrorResponse errorResponse = exception.getErrorResponse();
        HttpStatus status = HttpStatus.valueOf(exception.getErrorResponse().getStatus());
        log.error(errorResponse);
        return buildModelAndView(status, errorResponse);
    }

    private ModelAndView buildModelAndView(HttpStatus statusCode, ErrorResponse errorResponse) {
        Map<String, ErrorResponse> model = new HashMap<>();
        model.put("error", errorResponse);
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE, model);

        modelAndView.setStatus(statusCode);
        return modelAndView;
    }

}
