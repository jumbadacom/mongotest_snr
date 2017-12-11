package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;

public interface UserService  {
	
	public ResponseEntity<User> getCommentById(String id);
	
	public ResponseEntity<List<User>> getAllComments(Integer page, Integer size);
	
	public ResponseEntity<Void> save(User comment);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<Void> update(String id,User comment);
}
