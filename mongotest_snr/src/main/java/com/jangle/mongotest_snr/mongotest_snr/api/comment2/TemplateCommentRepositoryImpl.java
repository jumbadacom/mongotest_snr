package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;


public class TemplateCommentRepositoryImpl implements TemplateCommentRepositoryCustom {
	
	
	private final MongoOperations mongoOperations;
	
	@Autowired
	public TemplateCommentRepositoryImpl(MongoOperations mongoOperations) {
		this.mongoOperations =mongoOperations;}

	
	
	
//	@Override
//	public List<TemplateComment> findAllTemplateComments(Integer page, Integer size) {
//		
//		return null;
//	}

	@Override
	public TemplateComment findTemplateCommentById(String id) {
		
		return mongoOperations.findById(id, TemplateComment.class);
		
	}




}
