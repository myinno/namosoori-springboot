package io.namoosori.rest.store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore {
	
	private	Map<String, User> userMap;
	
	public UserStoreLogic() {
		this.userMap = new HashMap<>();
	}
	
	@Override
	public String create(User newUser) {
		userMap.put(newUser.getId(), newUser);
		return newUser.getId();
	}

	@Override
	public void update(User newUser) {
		userMap.put(newUser.getId(), newUser);  //기존값 변경됨
	}

	@Override
	public void delete(String id) {
		userMap.remove(id);

	}

	@Override
	public User retrive(String id) {
		return userMap.get(id);
	}

	@Override
	public List<User> retriveAll() {
		// TODO Auto-generated method stub
		return userMap.values().stream().collect(Collectors.toList());
	}

}
