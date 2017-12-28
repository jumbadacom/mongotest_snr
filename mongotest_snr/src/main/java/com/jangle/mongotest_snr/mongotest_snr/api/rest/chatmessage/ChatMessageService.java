package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;

public interface ChatMessageService  {
	
	public ResponseEntity<ChatMessage> getById(String id);
	
	public ResponseEntity<Void> save(ChatMessage comment);
	
	public ResponseEntity<Void> delete(String id);
	
	public ResponseEntity<Void> update(String id,ChatMessage comment);
	
	public ResponseEntity<List<ChatMessage>> getByUserId( String userId);
	
	public ResponseEntity<List<ChatMessage>> getByMostLikedAndUserId( String userId);
	
	public ResponseEntity<List<ChatMessage>> getByMostSharedAndUserId( String userId);
	
	public ResponseEntity<List<ChatMessage>> getByTypeAndUserId(Type type, String userId);
	
	public ResponseEntity<List<ChatMessage>> getByTypeAndUserIdAndIncludePassive(Type type, String userId);
	
	public ResponseEntity<List<ChatMessage>> getByRecently( String userId);
	
	public ResponseEntity<List<ChatMessage>> getByRecentlyAndIncludePassive( String userId);
	
	public ResponseEntity<List<ChatMessage>> getByTagAndRecentlyAndIncludePassive( String userId, List<String> tags);
	
	public ResponseEntity<List<ChatMessage>> getByTagAndRecently( String userId, List<String> tags);
	
	public ResponseEntity<List<ChatMessage>> getByUserUnlikedJangles(String userId);
	
	public ResponseEntity<List<ChatMessage>> getByViewCountBetweenAndLikeCountBetween(int viewCountBiggerThan,int viewCountLessThan, int likeCountBiggerThan, int likeCountLessThan);
}
