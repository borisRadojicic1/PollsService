package com.doodle.PollService.controllers;

import com.doodle.PollService.models.Poll;
import com.doodle.PollService.services.PollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public List<Poll> findPolls() {
        return pollService.findAll();
    }

}