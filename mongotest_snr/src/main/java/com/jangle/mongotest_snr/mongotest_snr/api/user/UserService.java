package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface UserService  {
	
	public ResponseEntity<Void> insert(User user);
	
	public ResponseEntity<Void> save(User user);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<User> getById(String id);
	
	public ResponseEntity<Void> update(String id,User user);
	
	public ResponseEntity<User> login(User user);
	
	public ResponseEntity<Void> logout(User user);
	
	public ResponseEntity<List<User>> getFriends(String userId);
	
	public ResponseEntity<List<User>> getFollowedUsers(String userId);
	
	public ResponseEntity<List<User>> getFollowerUsers(String userId);
	
	public ResponseEntity<List<User>> getByJangleCountOverAndViewCountOverAndSinceDate(int jangleCount, int viewCount, String dateString);
	
	
}
