package com.jangle.mongotest_snr.mongotest_snr.api.test;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, String>,TestRepositoryCustom{

}
