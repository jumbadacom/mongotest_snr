package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="api/users")
@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	
//	@GetMapping("/lastname/{lastname}")
//	public ResponseEntity<List<User>> getUsersByLastName( @PathVariable String lastname )
//	{
//		List<User> users=userService.getUsersByLastName(lastname);
//		
//		if(users.isEmpty())
//		{
//			return ResponseEntity.notFound().build();	
//		}
//		else
//		{
//			return ResponseEntity.ok(users);
//		}
//		
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById( @PathVariable String id )
	{
		return userService.getUserById(id);

	}
	
//	@GetMapping(params= {"page","size"})
//	public ResponseEntity<List<User>> getUsers(@RequestParam("page") Integer page, @RequestParam("size") Integer size)
//	{
//		
//		return userService.getAllUsers(page, size);
//	}
	
	@GetMapping(params= {"page","size"})
	public ResponseEntity<List<User>> getUsers2(@RequestParam("page") Integer page, @RequestParam("size") Integer size)
	{
		
		return userService.getAllUsers(page, size);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
