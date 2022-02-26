package io.namoosori.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	//생성은 @RequiredArgsConstructor에 의하여 이루어짐
	private	final UserService userService;
	
	@PostMapping("/users")
	public String register(@RequestBody User newUser) {
		//@RequestAttribute newUser가 Body에 있다
		//[org.springframework.web.bind.ServletRequestBindingException: Missing request attribute 'newUser' of type User]
		return userService.register(newUser);
	}
	
	@GetMapping("/users/{id}")  
	//{id}: Pass variable
	public User find(@PathVariable String id) {
		//@PathVariable이 없으면 id값을 받을 수 없음
		System.out.println(id);
		
		return userService.find(id);
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable String id) {
		userService.remove(id);
	}

	@PutMapping("/users")
	public void modify(@RequestBody User newUser) {
		userService.modify(newUser);
	}

}
