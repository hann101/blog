package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Exception을 한곳만 바라보게 하는 것
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value= Exception.class)
    public String handleArgumentException(Exception e){
        return "<h1>"+ e.getMessage()+"</h1>";
    }
}
