package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;

@Service
// @RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class ChatMessageServiceImpl implements ChatMessageService {

	private final ChatMessageRepository jangleRepository;

	public ChatMessageServiceImpl(ChatMessageRepository jangleRepository) {
		this.jangleRepository = jangleRepository;
	}

	@Override
	public ResponseEntity<ChatMessage> getById(String id) {
		Optional<ChatMessage> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(optUser.get());
	}

	@Override
	public ResponseEntity<Void> save(ChatMessage comment) {
		ChatMessage sonuc = jangleRepository.insert(comment);
		if (sonuc != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		Optional<ChatMessage> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		ChatMessage temp = optUser.get();
		temp.setPassive(true);
		temp = jangleRepository.save(temp);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> update(String id, ChatMessage comment) {
		Optional<ChatMessage> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		ChatMessage temp = optUser.get();
		comment.setId(new ObjectId(id));
		temp = jangleRepository.save(comment);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByUserId( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByUserId(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByMostLikedAndUserId( String userId) {
		
		List<ChatMessage> jangleList = jangleRepository.getByMostLikedAndUserId(userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByMostSharedAndUserId( String userId) {
		
		List<ChatMessage> jangleList = jangleRepository.getByMostSharedAndUserId( userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByTypeAndUserId( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByTypeAndUserId(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByTypeAndUserIdAndIncludePassive( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByTypeAndUserIdAndIncludePassive(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByRecently( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByRecently(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByRecentlyAndIncludePassive( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByRecentlyAndIncludePassive(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByTagAndRecentlyAndIncludePassive( String userId, List<String> tags) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByTagAndRecentlyAndIncludePassive(pageable, userId, tags);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByTagAndRecently( String userId, List<String> tags) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByTagAndRecently(pageable, userId,tags);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByViewCountBetweenAndLikeCountBetween(
			int viewCountBiggerThan, int viewCountLessThan, int likeCountBiggerThan, int likeCountLessThan) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByViewCountBetweenAndLikeCountBetween(pageable, viewCountBiggerThan, viewCountLessThan, likeCountBiggerThan, likeCountLessThan);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChatMessage>> getByUserUnlikedJangles(String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<ChatMessage> jangleList = jangleRepository.getByUserUnlikedJangles(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}


	/*
	 * @Override public ResponseEntity<Jangle> getCommentById(String id) {
	 * Optional<Jangle> optUser = jangleRepository.findById(id); if
	 * (!optUser.isPresent()) return ResponseEntity.notFound().build(); else return
	 * ResponseEntity.ok(optUser.get()); }
	 * 
	 * @Override public ResponseEntity<List<Jangle>> getAllComments(Integer page,
	 * Integer size){
	 * 
	 * return null; }
	 * 
	 * @Override public ResponseEntity<Void> save(Jangle user) { Jangle sonuc =
	 * jangleRepository.insert(user); if (sonuc != null) { return
	 * ResponseEntity.created(null).build(); } else { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 * 
	 * }
	 * 
	 * @Override public ResponseEntity<Void> delete(String id) throws
	 * java.lang.IllegalArgumentException { jangleRepository.deleteById(id); return
	 * ResponseEntity.ok().build(); }
	 * 
	 * @Override public ResponseEntity<Void> update(String id, Jangle comment) {
	 * 
	 * Optional<Jangle> optUser=jangleRepository.findById(id);
	 * if(!optUser.isPresent()) { return ResponseEntity.notFound().build(); }
	 * 
	 * Jangle temp=optUser.get();
	 * 
	 * 
	 * if (temp != null) { return ResponseEntity.created(null).build(); } else {
	 * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 * 
	 * }
	 */

}
