package com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle;

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

import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;


@RequestMapping(value = "api/jangles")
@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class JangleController {

	private final JangleService jangleService;

	public JangleController(JangleService jangleService)
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
	public ResponseEntity<Jangle> getById(@PathVariable String id) {
		return jangleService.getById(id);
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Jangle>> getByUserId(@PathVariable String userId) {
		return jangleService.getByUserId(userId);
	}

	@GetMapping("/getByMostLikedAndUserId/{userId}")
	public ResponseEntity<List<Jangle>> getByMostLikedAndUserId(String userId) {
		return jangleService.getByMostLikedAndUserId(userId);
	}

	@GetMapping("/getByMostSharedAndUserId/{userId}")
	public ResponseEntity<List<Jangle>> getByMostSharedAndUserId(String userId) {
		return jangleService.getByMostSharedAndUserId(userId);
	}

	@GetMapping(path="/getByTypeAndUserId/{userId}/type/{type}")
	public ResponseEntity<List<Jangle>> getByTypeAndUserId(@PathVariable(name="type") Type type, @PathVariable(name="userId") String userId) {
		return jangleService.getByTypeAndUserId(type, userId);
	}

	@GetMapping(path="/getByTypeAndUserIdAndIncludePassive/{userId}/type/{type}")
	public ResponseEntity<List<Jangle>> getByTypeAndUserIdAndIncludePassive(@PathVariable(name="type") Type type, @PathVariable(name="userId") String userId) {
		return jangleService.getByTypeAndUserIdAndIncludePassive(type, userId);
	}

	@GetMapping(path="/getByRecently/{userId}")
	public ResponseEntity<List<Jangle>> getByRecently(String userId) {
		return jangleService.getByRecently(userId);
	}

	@GetMapping(path="/getByRecentlyAndIncludePassive/{userId}")
	public ResponseEntity<List<Jangle>> getByRecentlyAndIncludePassive(String userId) {
		return jangleService.getByRecentlyAndIncludePassive(userId);
	}

	@GetMapping(path="/getByTagAndRecentlyAndIncludePassive/{userId}")
	public ResponseEntity<List<Jangle>> getByTagAndRecentlyAndIncludePassive(@PathVariable String userId,@RequestBody List<String> tags) {
		return jangleService.getByTagAndRecentlyAndIncludePassive(userId,tags);
	}

	@GetMapping(path="/getByTagAndRecently/{userId}")
	public ResponseEntity<List<Jangle>> getByTagAndRecently(@PathVariable String userId,@RequestBody List<String> tags) {
		return jangleService.getByTagAndRecently(userId,tags);
	}
	
	@GetMapping(path="/getByViewCountBetweenAndLikeCountBetween",params= {"viewCountBiggerThan","viewCountLessThan","likeCountBiggerThan","likeCountLessThan"})
	public ResponseEntity<List<Jangle>> getByViewCountBetweenAndLikeCountBetween(@RequestParam Integer viewCountBiggerThan,@RequestParam Integer viewCountLessThan,
			@RequestParam Integer likeCountBiggerThan,@RequestParam Integer likeCountLessThan) 
	{
		return jangleService.getByViewCountBetweenAndLikeCountBetween(viewCountBiggerThan, viewCountLessThan, likeCountBiggerThan, likeCountLessThan);
	}	
	
	@GetMapping(path="/getByUserUnlikedJangles/{userId}/userId")
	public ResponseEntity<List<Jangle>> getByUserUnlikedJangles(@PathVariable String userId) 
	{
		return jangleService.getByUserUnlikedJangles(userId);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Jangle jangle) {
		return jangleService.save(jangle);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return jangleService.delete(id);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Jangle jangle) {
		return jangleService.update(id,jangle);
	}
	
	
}
