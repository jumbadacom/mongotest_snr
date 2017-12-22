package com.jangle.mongotest_snr.mongotest_snr.api.rest.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> , UserRepositoryCustom
{

	public User findFirstByUserNameAndPassword(String userName, String password);
	
}
