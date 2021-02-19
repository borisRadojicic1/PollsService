package com.doodle.PollService.services;

import com.doodle.PollService.models.Poll;

import java.util.List;

public interface PollService {
    List<Poll> findAll();
    List<Poll> saveAll(List<Poll> polls);
}
