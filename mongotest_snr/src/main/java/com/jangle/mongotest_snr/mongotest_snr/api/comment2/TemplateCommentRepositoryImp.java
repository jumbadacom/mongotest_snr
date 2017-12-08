package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TemplateCommentRepositoryImp implements TemplateCommentRepositoryCustom {

	@Autowired
	public MongoTemplate mongoTemplate;
	
//	@Override
//	public List<TemplateComment> findAllTemplateComments(Integer page, Integer size) {
//		
//		return null;
//	}

	@Override
	public TemplateComment findTemplateCommentById(String id) {
		return mongoTemplate.findById(id, TemplateComment.class);
	}

/*
 * criteria = criteria.and("_id").is(new ObjectId(id));
 */



}
