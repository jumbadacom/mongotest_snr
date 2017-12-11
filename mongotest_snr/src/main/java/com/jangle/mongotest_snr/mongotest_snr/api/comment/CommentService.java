package com.jangle.mongotest_snr.mongotest_snr.api.comment;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CommentService  {
	
	public ResponseEntity<Comment> getCommentById(String id);
	
	public ResponseEntity<List<Comment>> getAllComments(Integer page, Integer size);
	
	public ResponseEntity<Void> save(Comment comment);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<Void> update(String id,Comment comment);
	
	
	public ResponseEntity<List<Comment>> getCommentByCommentUserId(String id);
	
	
}
