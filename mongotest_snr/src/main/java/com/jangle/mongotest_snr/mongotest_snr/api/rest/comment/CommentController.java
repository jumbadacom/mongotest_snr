package com.jangle.mongotest_snr.mongotest_snr.api.rest.comment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "api/comments")
@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService)
	{
		this.commentService=commentService;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable String id) {
		return commentService.getCommentById(id);

	}
	
	@GetMapping("/{commentUserId}/user")
	public ResponseEntity<List<Comment>> getCommentByCommentUserId(@PathVariable String commentUserId) {
		return commentService.getCommentByCommentUserId(commentUserId);

	}

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<List<Comment>> getComments2(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

//		return commentService.getCommentById(id);
		return null;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Comment comment) {
		return commentService.save(comment);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return commentService.delete(id);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Comment comment) {
		return commentService.update(id,comment);

	}

}
