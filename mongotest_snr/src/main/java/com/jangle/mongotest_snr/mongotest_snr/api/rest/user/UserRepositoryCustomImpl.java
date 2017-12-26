package com.jangle.mongotest_snr.mongotest_snr.api.rest.user;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.Jangle;
import com.jangle.mongotest_snr.mongotest_snr.api.rest.user.model.User;
import com.mongodb.BasicDBObject;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	
    MongoOperations mongoOperations;
	
	@Autowired
	public UserRepositoryCustomImpl (MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	
	}


	@Override
	public User getById(String id) {
		return this.mongoOperations.findById(id, User.class);
	}


	@Override
	public User login(User user) {
		if(user==null || user.getUserName()==null || user.getPassword()==null)
		{
			return null;
		}
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("password").is(user.getPassword()).andOperator(Criteria.where("userName").is(user.getUserName()))));
		 User tempUser=mongoOperations.findOne(query, User.class);
		 tempUser.setLastLogin(LocalDateTime.now());
		 mongoOperations.save(tempUser);
		 return tempUser;
		
	}

	@Override
	public void logout(User user) { 
		if(user==null || user.getUserName()==null || user.getPassword()==null)
		{
			return;
		}
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("password").is(user.getPassword()).andOperator(Criteria.where("userName").is(user.getUserName()))));
		 User tempUser=mongoOperations.findOne(query, User.class);
		 tempUser.setLastLogout(LocalDateTime.now());
		 mongoOperations.save(tempUser);
		 return ;
		
	}


	@Override
	public List<User> getFriends(Pageable pageable, String userId) {
		User user=mongoOperations.findById(userId, User.class);
		if(user==null)
		{
			return null;
		}		
		
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).and("_id").in(user.getFriendUserId()));
		query.with(pageable);
		 List<User> friends = mongoOperations.find(query, User.class);
		return friends;
	}


	@Override
	public List<User> getFollowedUsers(Pageable pageable, String userId) {
		User user=mongoOperations.findById(userId, User.class);
		if(user==null)
		{
			return null;
		}
		
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("_id").in(user.getFollowedUserId())));
		query.with(pageable);
		return mongoOperations.find(query, User.class);
	}


	@Override
	public List<User> getFollowerUsers(Pageable pageable, String userId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("followedUserId").is(userId)));
		query.with(pageable);
		return mongoOperations.find(query, User.class);
	}


	@Override
	public List<User> getByJangleCountOverAndViewCountOverAndSinceDate(Pageable pageable, int jangleCount, int viewCount, Date date) {

		MatchOperation matchStage =Aggregation.match(Criteria.where("registeredTime").gt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
//		GroupOperation groupStage =Aggregation.group("userId").count().as("jangleCount"); 
//		MatchOperation matchStageHaving =Aggregation.match(Criteria.where("jangleCount").gt(jangleCount));
		SortOperation sortStage = Aggregation.sort(pageable.getSort());
		LimitOperation limitOperation=Aggregation.limit(10);
		
		
		Aggregation aggregation = Aggregation.newAggregation(
				matchStage,
//				groupStage,
//				matchStageHaving,
				sortStage,
				limitOperation
				);
		System.out.println(aggregation.toString());
		
		List<BasicDBObject> userIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();

		Query query=new Query();
		query.addCriteria(Criteria.where("id").in(userIds));
		return mongoOperations.find(query, User.class);
	}

	

//	@Override
//	public List<User> getByUserId(Pageable pageable, String userId) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("passive").is(false)));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//
//	}
//
//	@Override
//	public List<User> getByMostLikedAndUserId(String userId) {
//		Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.project().and("likeUserId").project("size").as("count"),
//                Aggregation.match(Criteria.where("passive").is(false).andOperator(Criteria.where("userId").is(userId))),
//                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
//                Aggregation.limit(10)
//				);
//
//		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();
//
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").in(jangleIds)));
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByMostSharedAndUserId(String userId) {
//		Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.project().and("sharedUserId").project("size").as("count"),
//                Aggregation.match(Criteria.where("passive").is(false).andOperator(Criteria.where("userId").is(userId))),
//                Aggregation.sort(new Sort(Sort.Direction.DESC, "count")),
//                Aggregation.limit(10)
//				);
//
//		List<BasicDBObject> jangleIds = mongoOperations.aggregate(aggregation, "jangle", BasicDBObject.class).getMappedResults();
//
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").in(jangleIds)));
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByTypeAndUserId(Pageable pageable, Type type, String userId) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("type").is(type)).andOperator(Criteria.where("passive").is(false)));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByTypeAndUserIdAndIncludeHided(Pageable pageable, Type type, String userId) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("type").is(type)));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByRecently(Pageable pageable, String userId) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("passive").is(false)));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByRecentlyAndIncludeHided(Pageable pageable, String userId) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("userId").is(userId));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByTagAndRecentlyAndIncludeHided(Pageable pageable, String userId, List<String> tags) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("tags").andOperator(Criteria.where("userId").is(userId)));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}
//
//	@Override
//	public List<User> getByTagAndRecently(Pageable pageable, String userId, List<String> tags) {
//		Query query=new Query();
//		query.addCriteria(Criteria.where("passive").andOperator(Criteria.where("tags").andOperator(Criteria.where("userId").is(userId))));
//		query.with(pageable);
//		return mongoOperations.find(query, User.class);
//	}

}
