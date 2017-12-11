package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface TemplateCommentRepositoryCustom {
	
	public TemplateComment findTemplateCommentById(String id);
	
	public List<TemplateComment> getCommentByCommentUserId(Pageable pageable,String id);
	
	public List<TemplateComment> getCommentsByShareIdAndTopTenMostLikedAndNotDeletedAndContainsText(Pageable pageable, String shareId,String text);
	
	
	

}
