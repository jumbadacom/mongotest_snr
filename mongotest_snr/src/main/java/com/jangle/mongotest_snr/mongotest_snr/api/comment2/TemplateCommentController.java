package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller - bean
 * @Service - service
 * @Repository - dao
 */

@RequestMapping(value = "api/templatecomments")
@RestController
public class TemplateCommentController {

	private TemplateCommentService templateCommentService;

	public TemplateCommentController(TemplateCommentService templateCommentService) {
		this.templateCommentService = templateCommentService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<TemplateComment> getTemplateCommentById(@PathVariable String id) {
		return templateCommentService.getTemplateCommentById(id);
	}

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<List<TemplateComment>> getTemplateComments2(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		return null;
	}

}
