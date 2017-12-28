package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;
import com.mongodb.BasicDBObject;

public interface ChatMessageRepositoryCustom {

	public List<ChatMessage> getByUserId(Pageable pageable, String userId); 

	public List<ChatMessage> getByMostLikedAndUserId(String userId);

	public List<ChatMessage> getByMostSharedAndUserId(String userId);

	public List<ChatMessage> getByTypeAndUserId(Pageable pageable, Type type, String userId);

	public List<ChatMessage> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId);

	public List<ChatMessage> getByRecently(Pageable pageable, String userId);

	public List<ChatMessage> getByRecentlyAndIncludePassive(Pageable pageable, String userId);

	public List<ChatMessage> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags);

	public List<ChatMessage> getByTagAndRecently(Pageable pageable, String userId, List<String> tags);
	
	public List<ChatMessage> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan, int viewCountLessThan,int likeCountBiggerThan, int likeCountLessThan);

	public List<ChatMessage> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount);
	
	public List<ChatMessage> getByUserUnlikedJangles(Pageable pageable, String userId);
	
	public AggregationResults<BasicDBObject> test();
	
	public AggregationResults<TypeCount> test2(String userId);
}
