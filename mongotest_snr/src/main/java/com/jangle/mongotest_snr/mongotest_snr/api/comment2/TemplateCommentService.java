package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TemplateCommentService  {
	
	public ResponseEntity<TemplateComment> getTemplateCommentById(String id);
	
	public ResponseEntity<List<TemplateComment>> getAllTemplateComment(Integer page, Integer size);
}
