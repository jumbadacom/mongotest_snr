package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TemplateCommentServiceImpl implements TemplateCommentService {

	private TemplateCommentRepository templateCommentRepository;

	public TemplateCommentServiceImpl(TemplateCommentRepository templateCommentRepository) {
		this.templateCommentRepository = templateCommentRepository;
	}


	@Override
	public ResponseEntity<List<TemplateComment>> getAllTemplateComment(Integer page, Integer size) {

		return null;
	}

	@Override
	public ResponseEntity<TemplateComment> getTemplateCommentById(String id) {
		TemplateComment comment = templateCommentRepository.findTemplateCommentById(id);
		if (comment == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(comment);
	}

}
