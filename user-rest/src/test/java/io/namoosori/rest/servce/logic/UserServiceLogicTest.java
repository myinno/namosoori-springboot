package io.namoosori.rest.servce.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;

@SpringBootTest
public class UserServiceLogicTest {
	
	@Autowired   //Test는 Autowired방식으로만
 	private UserService userService;
	
	
	private User kim;
	private User lee;
	
	//테스트 데이터 정리하기 우;하여
	@BeforeEach
	public void startUp() {
		kim = new User("kim", "kim@namoosori");
		lee = new User("lee", "lee@namoosori");
		userService.register(kim);
		userService.register(lee);
	}
	
	@Test
	public void registerTest() {
		User sample = User.sample();
		assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
		assertThat(this.userService.findAll().size()).isEqualTo(3);
		this.userService.remove(sample.getId());
	}

	@Test
	public void find( ) {
		assertThat(this.userService.find(lee.getId())).isNotNull();
		assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
	}

	@AfterEach
	public void cleanup() {
		this.userService.remove(kim.getId());
		this.userService.remove(lee.getId());
		
	}
}

