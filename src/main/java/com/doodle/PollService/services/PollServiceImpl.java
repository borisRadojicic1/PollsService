package com.doodle.PollService.services;

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
        return repository.findAll();
    }

    @Override
    public List<Poll> findAllByTitle(final String title) {
        return repository.findAllByTitle(title);
    }

    @Override
    public List<Poll> findAllCreatedAfter(final Long dateMillis) {
        final Timestamp dateTimestamp = dateMillisToTimestamp(dateMillis);
        return repository.findAllCreatedAfter(dateTimestamp);
    }

    @Override
    public List<Poll> saveAll(final List<Poll> polls) {
        final List<Poll> pollsSaved = repository.saveAll(polls);
        repository.flush();
        return pollsSaved;
    }

    private Timestamp dateMillisToTimestamp(final Long dateMillis) {
        try {
            final Instant instant = Instant.ofEpochMilli(dateMillis);
            return Timestamp.from(instant);
        } catch (DateTimeException | IllegalArgumentException e) {
            return null;
        }
    }

}

