package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;

public interface UserRepositoryCustom {

	public User getById(String id);

	public User login(User user);

	public void logout(User user);

	public List<User> getFriends(User user);

	public List<User> getFollowedUsers(User user);

	public List<User> getFollowerUsers(User user);

}
