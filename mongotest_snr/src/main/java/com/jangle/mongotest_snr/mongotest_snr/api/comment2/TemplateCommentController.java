package com.jangle.mongotest_snr.mongotest_snr.api.comment2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "api/templatecomments")
@RestController
public class TemplateCommentController {

	private final TemplateCommentService templateCommentService;

	@Autowired
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
	
	@GetMapping(params = { "shareId", "text" })
	public ResponseEntity<List<TemplateComment>> getCommentsByShareIdAndTopTenMostLikedAndNotDeletedAndContainsText(@RequestParam("shareId") String shareId,@RequestParam("text") String text)
	{
		return templateCommentService.getCommentsByShareIdAndTopTenMostLikedAndNotDeletedAndContainsText(shareId, text);
	}
	
	@GetMapping("/{commentUserId}/user")
	public ResponseEntity<List<TemplateComment>> getCommentByCommentUserId(@PathVariable String commentUserId) {
		return templateCommentService.getCommentByCommentUserId(commentUserId);
	}

}
