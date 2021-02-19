package com.doodle.PollService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public static final String BAD_REQUEST_MESSAGE = "Some parameters are invalid";

    public BadRequestException() {
        super(BAD_REQUEST_MESSAGE);
    }

}
