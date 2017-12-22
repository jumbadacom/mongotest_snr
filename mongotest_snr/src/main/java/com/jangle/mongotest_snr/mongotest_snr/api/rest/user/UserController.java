package com.jangle.mongotest_snr.mongotest_snr.api.rest.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user.model.User;

/*
 * @Controller - bean
 * @Service - service
 * @Repository - dao
 */

@RequestMapping(value = "api/users")
@RestController
// @RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getCommentById(@PathVariable String id) {
		return userService.getById(id);

	}

	@GetMapping("/findFriendsByUserId/{id}")
	public ResponseEntity<List<User>> getFriends(@PathVariable String id) {
		return userService.getFriends(id);
	}

	@GetMapping("/findFollowerUsersByUserId/{id}")
	public ResponseEntity<List<User>> getFollowerUsers(@PathVariable String id) {
		return userService.getFollowerUsers(id);
	}

	@GetMapping("/findFollowedUsersByUserId/{id}")
	public ResponseEntity<List<User>> getFollowedUsers(@PathVariable String id) {
		return userService.getFollowedUsers(id);
	}

	@GetMapping(path = "/findByJangleCountOverAndViewCountOverAndSinceDate", params = { "jangleCount", "viewCount",
			"date" })
	@Deprecated /*Bu metod SQL Query'de hata mevcut*/
	public ResponseEntity<List<User>> findByJangleCountOverAndViewCountOverAndSinceDate(
			@RequestParam("jangleCount") Integer jangleCount, @RequestParam("viewCount") Integer viewCount,
			@RequestParam("date") String dateString) {
		return userService.getByJangleCountOverAndViewCountOverAndSinceDate(jangleCount, viewCount, dateString);
	}

	// @GetMapping(params = { "page", "size" })
	// public ResponseEntity<List<User>> getComments2(@RequestParam("page") Integer
	// page,
	// @RequestParam("size") Integer size) {
	//
	// return null;
	// }

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody User user) {
		return userService.save(user);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		return userService.delete(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody User user) {
		return userService.update(id, user);

	}

}
