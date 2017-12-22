package com.jangle.mongotest_snr.mongotest_snr.api.rest.comment2;

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

	
	@Override
	public TemplateComment findTemplateCommentById(String id) {
		
		return mongoOperations.findById(id, TemplateComment.class);
		
	}


	@Override
	public List<TemplateComment> getCommentByCommentUserId(Pageable pageable, String id) {
		Query query=new Query();
		query.addCriteria(Criteria.where("commentUserId").is(id));
		query.with(pageable);
		return mongoOperations.find(query, TemplateComment.class);
	}




	@Override
	public List<TemplateComment> getCommentsByShareIdAndTopTenMostLikedAndNotDeletedAndContainsText(Pageable pageable , String shareId, String text) {
		Query query=new Query();
		query.addCriteria(Criteria.where("sharedId").is(shareId).andOperator(Criteria.where("isDeleted").is(false).andOperator(Criteria.where("text").regex(".*"+text+".*"))));
		query.with(pageable);
		return mongoOperations.find(query, TemplateComment.class);
	}
	
	




}
