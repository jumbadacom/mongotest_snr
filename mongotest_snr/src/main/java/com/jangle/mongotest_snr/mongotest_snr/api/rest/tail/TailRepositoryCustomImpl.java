package com.jangle.mongotest_snr.mongotest_snr.api.rest.tail;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class TailRepositoryCustomImpl implements TailRepositoryCustom {
	
    MongoOperations mongoOperations;
	
	@Autowired
	public TailRepositoryCustomImpl (MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<Tail> getByUserId(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByMostLikedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("likeUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByMostSharedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("sharedUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByRecently(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByRecentlyAndIncludePassive(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("tags").and("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByTagAndRecently(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").andOperator(Criteria.where("tags").in(tags).and("userId").is(userId)));
		query.with(pageable);
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan,
			int viewCountLessThan, int likeCountBiggerThan, int likeCountLessThan) {
		Criteria cr=Criteria.where("passive").is(false)
		.andOperator(
				new Criteria[] {
						Criteria.where("likeCount").gte(likeCountBiggerThan),
						Criteria.where("likeCount").lte(likeCountLessThan)
								}
					)
		.andOperator(
				new Criteria[] {
						Criteria.where("viewCount").gte(viewCountBiggerThan),
						Criteria.where("viewCount").lte(viewCountLessThan)
								}
					);
				
		Query query=new Query();
		query.addCriteria(cr);
		query.with(pageable);
		
		return mongoOperations.find(query, Tail.class);
	}

	@Override
	public List<Tail> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount) {
		Criteria cr=Criteria.where("passive").is(false)
				.and("likeCount").gte(likeCount)
				.and("viewCount").gte(viewCount);
				Query query=new Query();
				query.addCriteria(cr);
				query.with(pageable);
				return mongoOperations.find(query, Tail.class);
	}

	@Override
	public void denemeSorgu() {
			
		Date date=new Date();
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("registeredTime").lte(date).and("type").is("IMAGE").and("passive").is(true).and("tailUserId").exists(true)),
                Aggregation.limit(10)
				);
		
		
		
		org.springframework.data.mongodb.core.aggregation.AggregationOptions option = org.springframework.data.mongodb.core.aggregation.AggregationOptions.builder().cursorBatchSize(10).build();
		
		aggregation.withOptions(option);
		
		System.out.println(aggregation);
		AggregationResults<Tail> sonuc =mongoOperations.aggregate(aggregation, "jangle", Tail.class);
		
//		MongoCollection<Document> collection = mongoOperations.getCollection("jangle");
//	     DBCursor cursor = collection.find();        
//		
//		Iterator<Tail> ite=sonuc.iterator();
//		
//		while(ite.hasNext())
//		{
//			Tail t=ite.next();
//			System.out.println(t.getId());
//			System.out.println(t.getViewCount());
//			System.out.println(t.getLikeCount());
//			System.out.println(t.getShareCount());
//		}
	}

}
