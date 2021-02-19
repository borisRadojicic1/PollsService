package com.doodle.PollService.controllers;

import com.doodle.PollService.exceptions.PollNotFoundException;
import com.doodle.PollService.models.Poll;
import com.doodle.PollService.services.PollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public List<Poll> findPolls(@RequestParam(name = "title", required = false) final String title,
                                @RequestParam(name = "createdAfter", required = false) final Long dateMillis) {

        if (nonNull(title)) {
            final List<Poll> polls = pollService.findAllByTitle(title);
            return checkIsSuccessful(polls);
        }

        if (nonNull(dateMillis)) {
            final List<Poll> polls = pollService.findAllCreatedAfter(dateMillis);
            return checkIsSuccessful(polls);
        }

        final List<Poll> polls = pollService.findAll();
        return checkIsSuccessful(polls);
    }

    private List<Poll> checkIsSuccessful(final List<Poll> polls) throws PollNotFoundException {
        if (isEmpty(polls)) throw new PollNotFoundException();
        return polls;
    }

}