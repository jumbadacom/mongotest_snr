package com.jangle.mongotest_snr.mongotest_snr.api.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> , UserRepositoryCustom
{
	
}
