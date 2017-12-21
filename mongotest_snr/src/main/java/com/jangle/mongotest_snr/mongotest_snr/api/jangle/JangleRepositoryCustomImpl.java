package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.bson.types.ObjectId;
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
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByMostLikedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("likeUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByMostSharedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("sharedUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByRecently(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByRecentlyAndIncludePassive(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("tags").and("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByTagAndRecently(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").andOperator(Criteria.where("tags").in(tags).and("userId").is(userId)));
		query.with(pageable);
		return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan,int viewCountLessThan, int likeCountBiggerThan, int likeCountLessThan) {
		Criteria cr=Criteria.where("passive").is(false)
		.andOperator(
				new Criteria[] {
						Criteria.where("likeCount").gte(likeCountBiggerThan),
						Criteria.where("likeCount").lte(likeCountLessThan),
						Criteria.where("viewCount").gte(viewCountBiggerThan),
						Criteria.where("viewCount").lte(viewCountLessThan)
								}
					);
				
		Query query=new Query();
		query.addCriteria(cr);
		query.with(pageable);
		List<Jangle> jangles=mongoOperations.find(query, Jangle.class);
		return  jangles;
	}

	@Override
	public List<Jangle> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount) {
		Criteria cr=Criteria.where("passive").is(false)
				.and("likeCount").gte(likeCount)
				.and("viewCount").gte(viewCount);
						
				Query query=new Query();
				query.addCriteria(cr);
				query.with(pageable);
				
				return mongoOperations.find(query, Jangle.class);
	}

	@Override
	public List<Jangle> getByUserUnlikedJangles(Pageable pageable, String userId) {
		Criteria cr=Criteria.where("passive").is(false).and("likeCount").is(0).and("userId").is(new ObjectId(userId));
		
		Query query=new Query();
		query.addCriteria(cr);
		query.with(pageable);
		
		return mongoOperations.find(query, Jangle.class);	
	}

}
