package com.jangle.mongotest_snr.mongotest_snr.api.rest.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user.model.User;

public interface UserRepositoryCustom {

	public User getById(String id);

	public User login(User user);

	public void logout(User user);

	public List<User> getFriends(Pageable pageable, String userId);

	public List<User> getFollowedUsers(Pageable pageable, String userId);

	public List<User> getFollowerUsers(Pageable pageable, String userId);
	
	public List<User> getByJangleCountOverAndViewCountOverAndSinceDate(Pageable pageable, int jangleCount, int viewCount, Date date);
	
	

}
