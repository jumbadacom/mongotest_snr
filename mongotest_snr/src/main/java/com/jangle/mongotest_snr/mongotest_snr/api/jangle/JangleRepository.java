package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

//import java.util.List;
//import java.util.Optional;-
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JangleRepository extends MongoRepository<Jangle, String>, JangleRepositoryCustom
//, QuerydslPredicateExecutor<Comment> 
{
	
	
	
//
//	public Optional<Jangle> findByEmail(String email);
//	
//	@Query(value="{'jangleName' : '?0'}")
//	public Jangle findByJanglename (String janglename);
//		
//	@Query(value="{'lastName' : '?0'}")
//	public List<Jangle> findByLastName(String lastName);
//	
//	
//	@Query(value="{'addresses.city' : '?0'}")
//	public List<Jangle> findByCity (Pageable pageable, String city);
//	
//	@Query(value="{'addresses.street' : '?0'}")
//	public List<Jangle> findByStreet (String street);
//	
//	@Query(value="{$and : [{'addresses.city': '?0'},{'addresses.city' : '?1'}]}")
//	public List<Jangle> findByCityAndDistrict(String city,String district);

	
	
	
	
	
}
