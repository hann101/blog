package com.cos.blog.handler;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Exception을 한곳만 바라보게 하는 것
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value= Exception.class)
    public ResponseDto<String> handleArgumentException(Exception e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }
}
