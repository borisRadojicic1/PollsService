package com.doodle.PollService;

import com.doodle.PollService.helpers.PollsMapper;
import com.doodle.PollService.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PollServiceApplication {

	@Autowired
	private PollsMapper pollsMapper;

	@Bean
	CommandLineRunner runner(PollService pollService) {
		return args -> {
			pollsMapper.mapPollsJsonToDb(pollService);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PollServiceApplication.class, args);
	}

}
