package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;
import com.mongodb.BasicDBObject;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class ChatMessageRepositoryCustomImpl implements ChatMessageRepositoryCustom {
	
    MongoOperations mongoOperations;
	
	@Autowired
	public ChatMessageRepositoryCustomImpl (MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<ChatMessage> getByUserId(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByMostLikedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("likeUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByMostSharedAndUserId(String userId) {
		Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project().and("sharedUserId").project("size").as("count"),
                Aggregation.match(Criteria.where("passive").is(false).and("userId").is(userId)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
                Aggregation.limit(10)
				);

		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("id").in(jangleIds));
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByTypeAndUserIdAndIncludePassive(Pageable pageable, Type type, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("type").is(type));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByRecently(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId).and("passive").is(false));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByRecentlyAndIncludePassive(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByTagAndRecentlyAndIncludePassive(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("tags").and("userId").is(userId));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByTagAndRecently(Pageable pageable, String userId, List<String> tags) {
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").andOperator(Criteria.where("tags").in(tags).and("userId").is(userId)));
		query.with(pageable);
		return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByViewCountBetweenAndLikeCountBetween(Pageable pageable, int viewCountBiggerThan,int viewCountLessThan, int likeCountBiggerThan, int likeCountLessThan) {
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
		List<ChatMessage> jangles=mongoOperations.find(query, ChatMessage.class);
		return  jangles;
	}

	@Override
	public List<ChatMessage> getByViewCountOverAndLikeCountOver(Pageable pageable, int viewCount, int likeCount) {
		Criteria cr=Criteria.where("passive").is(false)
				.and("likeCount").gte(likeCount)
				.and("viewCount").gte(viewCount);
						
				Query query=new Query();
				query.addCriteria(cr);
				query.with(pageable);
				
				return mongoOperations.find(query, ChatMessage.class);
	}

	@Override
	public List<ChatMessage> getByUserUnlikedJangles(Pageable pageable, String userId) {
		Criteria cr=Criteria.where("passive").is(false).and("likeCount").is(0).and("userId").is(new ObjectId(userId));
		
		Query query=new Query();
		query.addCriteria(cr);
		query.with(pageable);
		
		return mongoOperations.find(query, ChatMessage.class);	
	}
	
	
	
	public AggregationResults<BasicDBObject> test() {
		
		AggregationOperation group = Aggregation.group("userId").sum("viewCount").as("userViewCount");
		AggregationOperation matchFilter = Aggregation.match(new Criteria("userViewCount").gt(500000));
		AggregationOperation sort = Aggregation.sort(Sort.Direction.DESC, "userViewCount");
		AggregationOperation limit = Aggregation.limit(10);
		Aggregation aggregation =Aggregation.newAggregation(group,sort,matchFilter,limit);
		AggregationResults<BasicDBObject> result = mongoOperations.aggregate(aggregation,"views" ,BasicDBObject.class);
		return result;
		/*final Aggregation aggregation = newAggregation(
				new Sort(Sort.Direction.DESC, "viewCount"),
			);*/
	}
	
	public AggregationResults<TypeCount> test2(String userId) {
		Aggregation agg = newAggregation( 
				match(Criteria.where("_id").is(userId)),
				group("type").count().as("tip"),
				project("tip").and("type").previousOperation(),
				sort(Sort.Direction.DESC, "tip")
				);
		AggregationResults<TypeCount> groupResults =
		mongoOperations.aggregate(agg, ChatMessage.class ,TypeCount.class);
		return groupResults;
		
	}
	
	

}
