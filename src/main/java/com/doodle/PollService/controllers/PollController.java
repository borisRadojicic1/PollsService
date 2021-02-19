package com.doodle.PollService.controllers;

import com.doodle.PollService.models.Poll;
import com.doodle.PollService.services.PollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;

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
            return pollService.findAllByTitle(title);
        }

        if (nonNull(dateMillis)) {
            return pollService.findAllCreatedAfter(dateMillis);
        }

        return pollService.findAll();
    }

}