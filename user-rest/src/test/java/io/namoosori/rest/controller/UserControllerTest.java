package io.namoosori.rest.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.namoosori.rest.entity.User;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc  mockMvc;
	
	@Autowired
	private	ObjectMapper objectMapper; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegister() throws Exception{
//		fail("Not yet implemented");
		User sample = User.sample();
		String	content = objectMapper.writeValueAsString(sample);
		mockMvc.perform(post("/users")
						.content(content)  //입력을 전달하고
						.contentType(MediaType.APPLICATION_JSON)  //Typw 지정
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())  //처리결과가 정상인지
						.andExpect(content().string(sample.getId()))
						.andDo(print());
				
	}

	@Test
	void testFind() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testModify() {
		fail("Not yet implemented");
	}

	@Test
	void testUserController() {
		fail("Not yet implemented");
	}

}
