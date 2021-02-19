package com.doodle.PollService.helpers;

import com.doodle.PollService.models.DbInfo;
import com.doodle.PollService.models.Poll;
import com.doodle.PollService.repositories.DbInfoRepository;
import com.doodle.PollService.services.PollService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class PollsMapper {

    private static final Logger log = LoggerFactory.getLogger(PollsMapper.class);

    private static final String POLLS_JSON_PATH = "/assets/polls.json";

    @Autowired
    private DbInfoRepository dbInfoRepository;

    public void mapPollsJsonToDb(PollService pollService) {
        final TypeReference<List<Poll>> typeReference = new TypeReference<>() {
        };

        try (InputStream inputStream = TypeReference.class.getResourceAsStream(POLLS_JSON_PATH)) {
            final List<Poll> polls = getObjectMapper().readValue(inputStream, typeReference);
            final List<Poll> savedPolls = pollService.saveAll(polls);
            if (polls.equals(savedPolls)) {
                setDbPopulated();
                log.info("Users Saved!");
            }
        } catch (IOException e) {
            log.info("Unable to save users: " + e.getMessage());
        }
    }

    private ObjectMapper getObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
        return mapper;
    }

    public boolean isDbNotPopulated() {
        return isEmpty(dbInfoRepository.findAll());
    }

    private void setDbPopulated() {
        dbInfoRepository.save(new DbInfo(true));
    }

}
