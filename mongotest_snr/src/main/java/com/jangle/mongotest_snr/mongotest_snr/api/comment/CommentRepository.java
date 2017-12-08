package com.jangle.mongotest_snr.mongotest_snr.api.comment;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*Dao - Auto CRUD + Manuel eklenen*/
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

//	public Optional<Comment> findByAuthorUserId(String userId);
	
	
}
