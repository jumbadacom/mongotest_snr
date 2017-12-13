package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("_Id").in(user.getFriendUserId())));
		query.with(pageable);
		return mongoOperations.find(query, User.class);
	}


	@Override
	public List<User> getFollowedUsers(Pageable pageable, String userId) {
		User user=mongoOperations.findById(userId, User.class);
		if(user==null)
		{
			return null;
		}
		
		Query query=new Query();
		query.addCriteria(Criteria.where("passive").is(false).andOperator(Criteria.where("_Id").in(user.getFollowedUserId())));
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
