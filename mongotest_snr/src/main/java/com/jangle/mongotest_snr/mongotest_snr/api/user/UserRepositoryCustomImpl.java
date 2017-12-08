package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public void inserts(List<User> appUsers) {
		BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, User.class);
		for (User o : appUsers) {
		    bulkOperations.insert(o);
		}
	}

	@Override
	public List<User> getAllUsers(Integer page, Integer size) {
		
		return null;
	}
	
	

}
