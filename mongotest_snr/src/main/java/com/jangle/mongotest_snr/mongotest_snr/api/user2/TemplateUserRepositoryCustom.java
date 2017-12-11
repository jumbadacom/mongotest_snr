package com.jangle.mongotest_snr.mongotest_snr.api.user2;

import java.util.List;

public interface TemplateUserRepositoryCustom {
	
	public void inserts(List<TemplateUser> appUsers);

	public List<TemplateUser> getAllUsers(Integer page, Integer size);
}
