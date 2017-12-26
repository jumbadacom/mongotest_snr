package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2;

import java.util.List;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model.TemplateUser;

public interface TemplateUserRepositoryCustom {
	
	public void inserts(List<TemplateUser> appUsers);

	public List<TemplateUser> getAllUsers(Integer page, Integer size);
}
