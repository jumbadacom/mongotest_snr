package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserService  {

//	public List<User> getUsersByLastName(String name);
	
	public ResponseEntity<User> getUserById(String id);
	
	public ResponseEntity<List<User>> getAllUsers(Integer page, Integer size);
}
