package com.jangle.mongotest_snr.mongotest_snr.api.user2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class TemplateUserRepositoryImpl implements TemplateUserRepositoryCustom {
	
	
    MongoOperations mongoOperations;
	
	@Autowired
	public TemplateUserRepositoryImpl (MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	
	}

	
	@Override
	public void inserts(List<TemplateUser> appUsers) {
		BulkOperations bulkOperations = mongoOperations.bulkOps(BulkMode.UNORDERED, TemplateUser.class);
		for (TemplateUser o : appUsers) {
		    bulkOperations.insert(o);
		}
	}

	@Override
	public List<TemplateUser> getAllUsers(Integer page, Integer size) {
		return null;
	}
	
	

}
