package com.jangle.mongotest_snr.mongotest_snr.api.rest.share;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*Dao - Auto CRUD + Manuel eklenen*/
@Repository
public interface ShareRepository extends MongoRepository<Share, String> {

//	public Optional<Share> findByAuthorUserId(String userId);
	
	
}
