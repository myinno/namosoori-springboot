package io.namoosori.rest.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import io.namoosori.rest.store.UserStore;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor   //lombok이 지원하는 방식

public class UserServiceLogic implements UserService {
	//lombok 방식 ==@RequiredArgsConstructor
	private	final UserStore userStore;

	//bean이므로 주입되어야 한다 ==> 해당 IF을 구현한 구현 클래수를 찾는다
//	@Autowired
//	private	UserStore userStore;
	
	
	//autowired을 지정하지 않은 경우 생성자 방식
//	public UserServiceLogic(UserStore userStore) {
//		this.userStore = userStore;
//	}
	
	
	
	@Override
	public String register(User newUser) {
		
		return userStore.create(newUser);
	}

	@Override
	public void modify(User newUser) {
		userStore.update(newUser); 

	}

	@Override
	public void remove(String id) {
		userStore.delete(id);

	}

	@Override
	public User find(String id) {
		return userStore.retrive(id);
	}

	@Override
	public List<User> findAll() {
		return userStore.retriveAll();
	}

}
