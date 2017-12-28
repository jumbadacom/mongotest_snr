package com.jangle.mongotest_snr.mongotest_snr.api.rest.tail;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;

public interface TailRepositoryCustom {

	public List<Tail> getByUserId(Pageable pageable, String userId); 

	public List<Tail> getByMostLikedAndUserId(String userId);

	public List<Tail> getByMostSharedAndUserId(String userId);

	public List<Tail> getByTypeAndUserId(Pageable pageable, Type type, String userId);

	public List<Tail> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId);

	public List<Tail> getByRecently(Pageable pageable, String userId);

	public List<Tail> getByRecentlyAndIncludePassive(Pageable pageable, String userId);

	public List<Tail> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags);

	public List<Tail> getByTagAndRecently(Pageable pageable, String userId, List<String> tags);
	
	public List<Tail> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan, int viewCountLessThan,int likeCountBiggerThan, int likeCountLessThan);

	public List<Tail> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount);
	
	public void denemeSorgu();
}
