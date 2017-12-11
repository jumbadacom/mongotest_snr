package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TemplateCommentServiceImpl implements TemplateCommentService {

	private final TemplateCommentRepository templateCommentRepository;

	@Autowired
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

	
	@Override
	public ResponseEntity<List<TemplateComment>> getCommentByCommentUserId(String commentUserId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "likeCount"));
		List<TemplateComment> comments=templateCommentRepository.getCommentByCommentUserId(pageable,commentUserId);
		if (comments!=null && comments.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(comments);
	}

	
}
