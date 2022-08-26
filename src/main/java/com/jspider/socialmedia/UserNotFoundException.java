package com.jspider.socialmedia;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		System.out.println("invalid email and password");
	}
}
