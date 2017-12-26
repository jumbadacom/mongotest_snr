package com.jangle.mongotest_snr.mongotest_snr.api.rest.tail;

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
public class TailServiceImpl implements TailService {

	private final TailRepository jangleRepository;

	public TailServiceImpl(TailRepository jangleRepository) {
		this.jangleRepository = jangleRepository;
	}

	@Override
	public ResponseEntity<Tail> getById(String id) {
		Optional<Tail> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(optUser.get());
	}

	@Override
	public ResponseEntity<Void> save(Tail comment) {
		Tail sonuc = jangleRepository.insert(comment);
		if (sonuc != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		Optional<Tail> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Tail temp = optUser.get();
		temp.setPassive(true);
		temp = jangleRepository.save(temp);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> update(String id, Tail comment) {
		Optional<Tail> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Tail temp = optUser.get();
		comment.setId(new ObjectId(id));
		temp = jangleRepository.save(comment);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<List<Tail>> getByUserId( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByUserId(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByMostLikedAndUserId( String userId) {
		
		List<Tail> jangleList = jangleRepository.getByMostLikedAndUserId(userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByMostSharedAndUserId( String userId) {
		
		List<Tail> jangleList = jangleRepository.getByMostSharedAndUserId( userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByTypeAndUserId( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByTypeAndUserId(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByTypeAndUserIdAndIncludePassive( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByTypeAndUserIdAndIncludePassive(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByRecently( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByRecently(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByRecentlyAndIncludePassive( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByRecentlyAndIncludePassive(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByTagAndRecentlyAndIncludePassive( String userId, List<String> tags) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByTagAndRecentlyAndIncludePassive(pageable, userId, tags);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Tail>> getByTagAndRecently( String userId, List<String> tags) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Tail> jangleList = jangleRepository.getByTagAndRecently(pageable, userId,tags);
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
