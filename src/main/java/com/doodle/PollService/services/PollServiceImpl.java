package com.doodle.PollService.services;

import com.doodle.PollService.exceptions.BadRequestException;
import com.doodle.PollService.models.Poll;
import com.doodle.PollService.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    private PollRepository repository;

    @Override
    public List<Poll> findAll() {
        final List<Poll> polls = repository.findAll();
        return List.copyOf(polls);
    }

    @Override
    public List<Poll> findAllByTitle(final String title) {
        final List<Poll> polls = repository.findAllByTitle(title);
        return List.copyOf(polls);
    }

    @Override
    public List<Poll> findAllCreatedAfter(final Long dateMillis) {
        final Timestamp dateTimestamp = dateMillisToTimestamp(dateMillis);
        final List<Poll> polls = repository.findAllCreatedAfter(dateTimestamp);
        return List.copyOf(polls);
    }

    @Override
    public List<Poll> saveAll(final List<Poll> polls) {
        final List<Poll> pollsSaved = repository.saveAll(polls);
        repository.flush();
        return List.copyOf(pollsSaved);
    }

    private Timestamp dateMillisToTimestamp(final Long dateMillis) throws BadRequestException {
        try {
            final Instant instant = Instant.ofEpochMilli(dateMillis);
            return Timestamp.from(instant);
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException();
        }
    }
}
