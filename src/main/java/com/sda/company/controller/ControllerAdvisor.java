package com.sda.company.controller;

import com.sda.company.exception.CompanyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CompanyException.class)
    public ResponseEntity<Object> handlerCompanyException(CompanyException companyException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Time stamp", LocalDateTime.now());
        body.put("Error message", companyException.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}