package com.jangle.mongotest_snr.mongotest_snr.api.user;

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

/*
 * @Controller - bean
 * @Service - service
 * @Repository - dao
 */

@RequestMapping(value = "api/users")
@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserController {

	private final UserService userService;

	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<User> getCommentById(@PathVariable String id) {
		return userService.getById(id);

	}

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<List<User>> getComments2(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		return null;
	}

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
		return userService.update(id,user);

	}

}
