package com.jangle.mongotest_snr.mongotest_snr.api.rest.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository)
	{
		this.commentRepository=commentRepository;
	}


	@Override
	public ResponseEntity<Comment> getCommentById(String id) {
		Optional<Comment> comment = commentRepository.findById(id);
		if (!comment.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(comment.get());
	}

	@Override
	public ResponseEntity<List<Comment>> getAllComments(Integer page, Integer size){
		 
		return null;
	}

	@Override
	public ResponseEntity<Void> save(Comment comment) {
		Comment sonuc = commentRepository.insert(comment);
		if (sonuc != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@Override
	public ResponseEntity<Void> delete(String id) throws java.lang.IllegalArgumentException {
		commentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> update(String id, Comment comment) {
		
		Optional<Comment> commentDB=commentRepository.findById(id);
		if(!commentDB.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		Comment commentTemp=commentDB.get();
		commentTemp.setLikeCount(comment.getLikeCount());
		commentTemp.setExtra1(comment.getExtra1());
		commentTemp.setExtra2(comment.getExtra2());
		commentTemp.setExtra3(comment.getExtra3());
		commentTemp.setExtra4(comment.getExtra4());
		commentTemp.setExtra5(comment.getExtra5());
		commentTemp.setIsDeleted(comment.getIsDeleted());
		commentTemp.setText(comment.getText());
		commentTemp=commentRepository.save(commentTemp);
		
		if (commentTemp != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}


	@Override
	public ResponseEntity<List<Comment>> getCommentByCommentUserId(String id) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "likeCount"));
		List<Comment> comments = commentRepository.getCommentByCommentUserId(pageable,id);
		
		return ResponseEntity.ok(comments);
		
	}

	
}
