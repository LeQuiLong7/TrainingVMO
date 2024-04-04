package com.lql.springdemo.exception.handler;


import com.lql.springdemo.exception.model.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler({ UserNotFoundException.class})
    public ResponseEntity<Object> userNotFoundExceptionHandler(Exception ex) {
        log.error("An error occurred: {}", ex.getMessage(), ex);
        Map<String, String> detail = new HashMap<>();
        detail.put("error", ex.getMessage());
        detail.put("time_stamp", LocalDateTime.now().toString());

        return new ResponseEntity<>(detail, HttpStatus.BAD_REQUEST);
    }






}
