package com.jangle.mongotest_snr.mongotest_snr.api.comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String>
//,QuerydslPredicateExecutor<Comment> 
{

	//http://www.baeldung.com/queries-in-spring-data-mongodb
	//https://github.com/spring-projects/spring-data-examples/tree/master/web/querydsl
//	List<Comment> findComments(Integer page, Integer size,@QuerydslPredicate(root = Comment.class) Predicate predicate, Pageable pageable);
	
}
