package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model.TemplateUser;

public interface TemplateUserService  {

//	public List<User> getUsersByLastName(String name);
	
	public ResponseEntity<TemplateUser> getUserById(String id);
	
	public ResponseEntity<List<TemplateUser>> getAllUsers(Integer page, Integer size);
}
