package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestDocument, String>,TestRepositoryCustom{

}
