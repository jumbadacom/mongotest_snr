package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemplateCommentRepository extends MongoRepository<TemplateComment, String>,TemplateCommentRepositoryCustom {


	
	
}
