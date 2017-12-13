package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
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
	public List<Jangle> getByMostLikedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("likeUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).andOperator(Criteria.where("userId").is(userId))),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").in(jangleIds)));
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByMostSharedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("sharedUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).andOperator(Criteria.where("userId").is(userId))),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").in(jangleIds)));
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("type").is(type)).andOperator(Criteria.where("passive").is(false)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTypeAndUserIdAndIncludeHided(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("type").is(type)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByRecently(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("passive").is(false)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByRecentlyAndIncludeHided(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTagAndRecentlyAndIncludeHided(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("tags").andOperator(Criteria.where("userId").is(userId)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTagAndRecently(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").andOperator(Criteria.where("tags").andOperator(Criteria.where("userId").is(userId))));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

}
