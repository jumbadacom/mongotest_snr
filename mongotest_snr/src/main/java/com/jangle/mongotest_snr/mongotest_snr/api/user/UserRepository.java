package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/*Dao - Auto CRUD + Manuel eklenen*/
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> findByEmail(String email);
	
	@Query(value="{'userName' : '?0'}")
	public List<User> findByUsername (String username);
	
	@Query(value="{'addresses.city' : '?0'}")
	public List<User> findByCity (Pageable pageable, String city);
	
	
	@Query(value="{'addresses.street' : '?0'}")
	public List<User> findByStreet (String street);
	
	@Query(value="{$and : [{'addresses.city': '?0'},{'addresses.city' : '?1'}]}")
	public List<User> findByCityAndDistrict(String city,String district);
	
	
	
	
}
