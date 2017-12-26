package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class TestRepositoryCustomImpl implements TestRepositoryCustom {

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public boolean updateTestDocumentByName(String id, String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = Update.update("name", name);
		Optional<TestDocument> opt = Optional
				.ofNullable(mongoOperations.findAndModify(query, update, TestDocument.class));
		return opt.isPresent() ?true : false;
	}

	@Override
	public boolean updateTestDocumentAsPassive(String id) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = Update.update("is_passive", true);
		Optional<TestDocument> opt = Optional
				.ofNullable(mongoOperations.findAndModify(query, update, TestDocument.class));
		return opt.isPresent() ? true : false;
	}

}
