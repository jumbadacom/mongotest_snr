package com.jangle.mongotest_snr.mongotest_snr.api.tail;

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


@RequestMapping(value = "api/tails")
@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class TailController {

	private final TailService jangleService;

	public TailController(TailService jangleService)
	{
		this.jangleService=jangleService;
	}
	
//	@GetMapping(params = { "page", "size" })
//	public ResponseEntity<List<Jangle>> getComments2(@RequestParam("page") Integer page,
//			@RequestParam("size") Integer size) {
//
//		return null;
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Tail> getById(@PathVariable String id) {
		return jangleService.getById(id);
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Tail>> getByUserId(@PathVariable String userId) {
		return jangleService.getByUserId(userId);
	}


	@GetMapping("/getByMostLikedAndUserId/{userId}")
	public ResponseEntity<List<Tail>> getByMostLikedAndUserId(String userId) {
		return jangleService.getByMostLikedAndUserId(userId);
	}


	@GetMapping("/getByMostSharedAndUserId/{userId}")
	public ResponseEntity<List<Tail>> getByMostSharedAndUserId(String userId) {
		return jangleService.getByMostSharedAndUserId(userId);
	}


	@GetMapping(path="/getByTypeAndUserId/{userId}/type/{type}")
	public ResponseEntity<List<Tail>> getByTypeAndUserId(@PathVariable(name="type") Type type, @PathVariable(name="userId") String userId) {
		return jangleService.getByTypeAndUserId(type, userId);
	}


	@GetMapping(path="/getByTypeAndUserIdAndIncludePassive/{userId}/type/{type}")
	public ResponseEntity<List<Tail>> getByTypeAndUserIdAndIncludePassive(@PathVariable(name="type") Type type, @PathVariable(name="userId") String userId) {
		return jangleService.getByTypeAndUserIdAndIncludePassive(type, userId);
	}


	@GetMapping(path="/getByRecently/{userId}")
	public ResponseEntity<List<Tail>> getByRecently(String userId) {
		return jangleService.getByRecently(userId);
	}

	@GetMapping(path="/getByRecentlyAndIncludePassive/{userId}")
	public ResponseEntity<List<Tail>> getByRecentlyAndIncludePassive(String userId) {
		return jangleService.getByRecentlyAndIncludePassive(userId);
	}

	@GetMapping(path="/getByTagAndRecentlyAndIncludePassive/{userId}")
	public ResponseEntity<List<Tail>> getByTagAndRecentlyAndIncludePassive(@PathVariable String userId,@RequestBody List<String> tags) {
		return jangleService.getByTagAndRecentlyAndIncludePassive(userId,tags);
	}

	@GetMapping(path="/getByTagAndRecently/{userId}")
	public ResponseEntity<List<Tail>> getByTagAndRecently(@PathVariable String userId,@RequestBody List<String> tags) {
		return jangleService.getByTagAndRecently(userId,tags);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Tail jangle) {
		return jangleService.save(jangle);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return jangleService.delete(id);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Tail jangle) {
		return jangleService.update(id,jangle);

	}
}
