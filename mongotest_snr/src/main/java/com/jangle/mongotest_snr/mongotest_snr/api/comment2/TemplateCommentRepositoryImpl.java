package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


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


	@Override
	public List<TemplateComment> getCommentByCommentUserId(Pageable pageable, String id) {
Query query=new Query();
		
		query.addCriteria(Criteria.where("commentUserId").is(id));
//		query.limit(pageable.getPageNumber()*pageable.getPageSize());
//		query.with(pageable.getSort());
		query.with(pageable);
		return mongoOperations.find(query, TemplateComment.class);
		
	}




}
