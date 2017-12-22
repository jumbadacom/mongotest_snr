package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model.TemplateUser;

/*Dao - Auto CRUD + Manuel eklenen*/
@Repository
public interface TemplateUserRepository extends MongoRepository<TemplateUser, String> , TemplateUserRepositoryCustom {

	public Optional<TemplateUser> findByEmail(String email);
	
	@Query(value="{'userName' : '?0'}")
	public TemplateUser findByUsername (String username);
		
	@Query(value="{'lastName' : '?0'}")
	public List<TemplateUser> findByLastName(String lastName);
	
	
	@Query(value="{'addresses.city' : '?0'}")
	public List<TemplateUser> findByCity (Pageable pageable, String city);
	
	@Query(value="{'addresses.street' : '?0'}")
	public List<TemplateUser> findByStreet (String street);
	
	@Query(value="{$and : [{'addresses.city': '?0'},{'addresses.city' : '?1'}]}")
	public List<TemplateUser> findByCityAndDistrict(String city,String district);

	
	
	
	
	
}
