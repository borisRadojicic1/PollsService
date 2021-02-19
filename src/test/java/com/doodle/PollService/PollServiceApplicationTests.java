package com.doodle.PollService;

import com.doodle.PollService.controllers.PollController;
import com.doodle.PollService.helpers.PollsMapper;
import com.doodle.PollService.models.Poll;
import com.doodle.PollService.services.PollService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PollController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PollServiceApplicationTests {

	private List<Poll> polls;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PollController pollController;

	@MockBean
	private PollService pollService;

	@MockBean
	private PollsMapper pollsMapper;

	@BeforeAll
	public void setUp() {
		Poll poll1 = new Poll();
		Poll poll2 = new Poll();
		poll1.setId("xsd4cv89t5f5um4b");
		poll1.setAdminKey("r44d7piq");
		poll1.setTitle("Qui sont les superhéros Marvel les plus oufs?");
		poll2.setId("h75eeaudhf3tf3v3");
		poll2.setAdminKey("wyemiw4y");
		poll2.setTitle("可爱的宝宝👶🏼世界会变成2岁的1月12日时间过得真快");
		polls = new ArrayList<>(Arrays.asList(poll1, poll2));
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(pollController).isNotNull();
	}

	@Test
	public void findAllShouldReturnStatusNotFound() throws Exception {
		when(pollService.findAll())
				.thenReturn(Collections.emptyList());
		mockMvc.perform(get("/api/v1/polls"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void findAllShouldReturnListOfPolls() throws Exception {
		when(pollService.findAll())
				.thenReturn(polls);
		mockMvc.perform(get("/api/v1/polls"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@AfterAll
	public void clear() {
		polls.clear();
	}

}

