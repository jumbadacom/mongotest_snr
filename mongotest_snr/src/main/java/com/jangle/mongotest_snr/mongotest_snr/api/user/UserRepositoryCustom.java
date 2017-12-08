package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;

public interface UserRepositoryCustom {
	
	public void inserts(List<User> appUsers);

	public List<User> getAllUsers(Integer page, Integer size);
}
