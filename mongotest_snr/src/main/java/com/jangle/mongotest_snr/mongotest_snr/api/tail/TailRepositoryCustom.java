package com.jangle.mongotest_snr.mongotest_snr.api.tail;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface TailRepositoryCustom {

	public List<Tail> getByUserId(Pageable pageable, String userId); 

	public List<Tail> getByMostLikedAndUserId(String userId);

	public List<Tail> getByMostSharedAndUserId(String userId);

	public List<Tail> getByTypeAndUserId(Pageable pageable, Type type, String userId);

	public List<Tail> getByTypeAndUserIdAndIncludeHided(Pageable pageable, Type type, String userId);

	public List<Tail> getByRecently(Pageable pageable, String userId);

	public List<Tail> getByRecentlyAndIncludeHided(Pageable pageable, String userId);

	public List<Tail> getByTagAndRecentlyAndIncludeHided(Pageable pageable, String userId, List<String> tags);

	public List<Tail> getByTagAndRecently(Pageable pageable, String userId, List<String> tags);

}
