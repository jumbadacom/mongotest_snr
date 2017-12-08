package com.jangle.mongotest_snr.mongotest_snr.api.comment;

import java.util.List;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

	//http://www.baeldung.com/queries-in-spring-data-mongodb
	//https://github.com/spring-projects/spring-data-examples/tree/master/web/querydsl
	List<Comment> findComments(Integer page, Integer size,@QuerydslPredicate(root = Comment.class) Predicate predicate, Pageable pageable);
	
}
