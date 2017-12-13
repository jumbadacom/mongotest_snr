package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JangleRepository extends MongoRepository<Jangle, String>, JangleRepositoryCustom 
{
	
}
