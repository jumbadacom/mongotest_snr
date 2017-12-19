package com.jangle.mongotest_snr.mongotest_snr.api.tail;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TailRepository extends MongoRepository<Tail, String>, TailRepositoryCustom 
{
	
}
