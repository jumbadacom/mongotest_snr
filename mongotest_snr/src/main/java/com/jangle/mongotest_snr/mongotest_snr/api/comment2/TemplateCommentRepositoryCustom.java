package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface TemplateCommentRepositoryCustom {
	
//	public void inserts(List<TemplateComment> appComments);

	
//	public List<TemplateComment> findAllTemplateComments(Integer page, Integer size);
	
	public TemplateComment findTemplateCommentById(String id);
	
	public List<TemplateComment> getCommentByCommentUserId(Pageable pageable,String id);
	
	

}
