package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface JangleRepositoryCustom {

	public List<Jangle> getByUserId(Pageable pageable, String userId); 

	public List<Jangle> getByMostLikedAndUserId(String userId);

	public List<Jangle> getByMostSharedAndUserId(String userId);

	public List<Jangle> getByTypeAndUserId(Pageable pageable, Type type, String userId);

	public List<Jangle> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId);

	public List<Jangle> getByRecently(Pageable pageable, String userId);

	public List<Jangle> getByRecentlyAndIncludePassive(Pageable pageable, String userId);

	public List<Jangle> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags);

	public List<Jangle> getByTagAndRecently(Pageable pageable, String userId, List<String> tags);
	
	public List<Jangle> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan, int viewCountLessThan,int likeCountBiggerThan, int likeCountLessThan);

	public List<Jangle> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount);
}
