package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JangleRepositoryCustomImpl implements JangleRepositoryCustom {
	
	
    MongoOperations mongoOperations;
	
	@Autowired
	public JangleRepositoryCustomImpl (MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	
	}

	@Override
	public List<Jangle> getByUserId(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("passive").is(false)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);

	}

	@Override
	public List<Jangle> getByMostLikedAndUserId(Pageable pageable, String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("passive").is(false)),
                Aggregation.project().and("ids").project("size").as("count"));
		
		
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("passive").is(false)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByMostSharedAndUserId(Pageable pageable, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByTypeAndUserIdAndIncludeHided(Pageable pageable, Type type, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByRecently(Pageable pageable, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByRecentlyAndIncludeHided(Pageable pageable, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByTagAndRecentlyAndIncludeHided(Pageable pageable, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jangle> getByTagAndRecently(Pageable pageable, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
