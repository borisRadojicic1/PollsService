package com.doodle.PollService;

import com.doodle.PollService.models.Poll;
import com.doodle.PollService.services.PollService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class PollServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(PollServiceApplication.class);

	@Bean
	CommandLineRunner runner(PollService pollService) {
		return args -> {
			mapPollsJsonToDb(pollService);
		};
	}

	public void mapPollsJsonToDb(PollService pollService) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		TypeReference<List<Poll>> typeReference = new TypeReference<>() {
		};

		try (InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/polls.json")) {
			List<Poll> polls = mapper.readValue(inputStream, typeReference);
			//log.info("polls mapped " + polls.toString());
			List<Poll> savedPolls = pollService.saveAll(polls);
			//log.info("polls saved " + savedPolls.toString());
			if (polls.equals(savedPolls)) {
				log.info("Users Saved!");
			}
		} catch (IOException e) {
			log.info("Unable to save users: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PollServiceApplication.class, args);
	}

}
