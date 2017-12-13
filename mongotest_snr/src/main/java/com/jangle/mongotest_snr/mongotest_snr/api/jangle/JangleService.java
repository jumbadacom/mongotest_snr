package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface JangleService  {
	
	public ResponseEntity<Jangle> getById(String id);
	
	public ResponseEntity<Void> save(Jangle comment);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<Void> update(String id,Jangle comment);
	
	public ResponseEntity<List<Jangle>> getByUserId( String userId);
	
	public ResponseEntity<List<Jangle>> getByMostLikedAndUserId( String userId);
	
	public ResponseEntity<List<Jangle>> getByMostSharedAndUserId( String userId);
	
	public ResponseEntity<List<Jangle>> getByTypeAndUserId(Type type, String userId);
	
	public ResponseEntity<List<Jangle>> getByTypeAndUserIdAndIncludeHided(Type type, String userId);
	
	public ResponseEntity<List<Jangle>> getByRecently( String userId);
	
	public ResponseEntity<List<Jangle>> getByRecentlyAndIncludeHided( String userId);
	
	public ResponseEntity<List<Jangle>> getByTagAndRecentlyAndIncludeHided( String userId);
	
	public ResponseEntity<List<Jangle>> getByTagAndRecently( String userId);
}
