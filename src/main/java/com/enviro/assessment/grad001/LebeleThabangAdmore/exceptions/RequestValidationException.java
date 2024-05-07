package com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationException extends RuntimeException {
    public  RequestValidationException (String message) {

    }
}
