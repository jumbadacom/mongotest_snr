package com.jangle.mongotest_snr.mongotest_snr.api.rest.tail;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;

public interface TailService  {
	
	public ResponseEntity<Tail> getById(String id);
	
	public ResponseEntity<Void> save(Tail comment);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<Void> update(String id,Tail comment);
	
	public ResponseEntity<List<Tail>> getByUserId( String userId);
	
	public ResponseEntity<List<Tail>> getByMostLikedAndUserId( String userId);
	
	public ResponseEntity<List<Tail>> getByMostSharedAndUserId( String userId);
	
	public ResponseEntity<List<Tail>> getByTypeAndUserId(Type type, String userId);
	
	public ResponseEntity<List<Tail>> getByTypeAndUserIdAndIncludePassive(Type type, String userId);
	
	public ResponseEntity<List<Tail>> getByRecently( String userId);
	
	public ResponseEntity<List<Tail>> getByRecentlyAndIncludePassive( String userId);
	
	public ResponseEntity<List<Tail>> getByTagAndRecentlyAndIncludePassive( String userId, List<String> tags);
	
	public ResponseEntity<List<Tail>> getByTagAndRecently( String userId, List<String> tags);
}
