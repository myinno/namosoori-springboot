package io.namoosori.rest.entity;

import java.util.UUID;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class User {

	private	String	id;
	private	String	name;
	private	String	email;
	
	public User() {
		this.id = UUID.randomUUID().toString();
	}
	
	public User(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}

	public static void main(String[] args) {
		User user = new User("Myinno", "msa.myinno@gmail.com");
		System.out.println(new Gson().toJson(user));
	}
	//Test을 위하여
	public static User sample() {
		return new User("Myinno", "msa.myinno@gmail.com");
	}
}
