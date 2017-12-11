package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TemplateCommentService  {
	
	public ResponseEntity<TemplateComment> getTemplateCommentById(String id);
	
	public ResponseEntity<List<TemplateComment>> getAllTemplateComment(Integer page, Integer size);
	
	public ResponseEntity<List<TemplateComment>> getCommentByCommentUserId(String commentUserId);
	
	public ResponseEntity<List<TemplateComment>> getCommentsByShareIdAndTopTenMostLikedAndNotDeletedAndContainsText(String shareId,String text);
}
