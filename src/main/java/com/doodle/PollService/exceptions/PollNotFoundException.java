package com.doodle.PollService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PollNotFoundException extends RuntimeException {

    public static final String POLL_NOT_FOUND_MESSAGE = "Poll not found";

    public PollNotFoundException() {
        super(POLL_NOT_FOUND_MESSAGE);
    }

}
