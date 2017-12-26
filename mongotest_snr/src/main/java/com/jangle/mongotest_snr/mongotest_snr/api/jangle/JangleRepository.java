package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JangleRepository extends MongoRepository<Jangle, String>, JangleRepositoryCustom 
{
	public List<Jangle> findByViewCountGreaterThanIgnoreCase(Pageable pageable,int viewCount);
	
	public List<Jangle> findTop10ByViewCountGreaterThanIgnoreCase();
	
	
	@Query("{ 'viewCount' : {$gt : ?0 }}")
	public List<Jangle> findTop10ByViewcountGreaterThanOrderByViewcountDescQuery(Pageable pageable ,int viewCount);
}
