package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
// @RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class JangleServiceImpl implements JangleService {

	private final JangleRepository jangleRepository;

	public JangleServiceImpl(JangleRepository jangleRepository) {
		this.jangleRepository = jangleRepository;
	}

	@Override
	public ResponseEntity<Jangle> getById(String id) {
		Optional<Jangle> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(optUser.get());
	}

	@Override
	public ResponseEntity<Void> save(Jangle comment) {
		Jangle sonuc = jangleRepository.insert(comment);
		if (sonuc != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		Optional<Jangle> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Jangle temp = optUser.get();
		temp.setPassive(true);
		temp = jangleRepository.save(temp);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<Void> update(String id, Jangle comment) {
		Optional<Jangle> optUser = jangleRepository.findById(id);
		if (!optUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Jangle temp = optUser.get();
		/* deneme alan - dümdüz save edersek olduğu gibi güncelliyor mudur? */
		comment.setId(id);
		temp = jangleRepository.save(comment);

		if (temp != null) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<List<Jangle>> getByUserId( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByUserId(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByMostLikedAndUserId( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByMostLikedAndUserId(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByMostSharedAndUserId( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByMostSharedAndUserId(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByTypeAndUserId( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByTypeAndUserId(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByTypeAndUserIdAndIncludeHided( Type type, String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByTypeAndUserIdAndIncludeHided(pageable, type, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByRecently( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByRecently(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByRecentlyAndIncludeHided( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByRecentlyAndIncludeHided(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByTagAndRecentlyAndIncludeHided( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByTagAndRecentlyAndIncludeHided(pageable, userId);
		if (jangleList != null && !jangleList.isEmpty())
			return ResponseEntity.ok(jangleList);
		else
			return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<Jangle>> getByTagAndRecently( String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<Jangle> jangleList = jangleRepository.getByTagAndRecently(pageable, userId);
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
