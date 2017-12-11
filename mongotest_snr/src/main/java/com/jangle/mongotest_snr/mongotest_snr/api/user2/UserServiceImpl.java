package com.jangle.mongotest_snr.mongotest_snr.api.user2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}


	@Override
	public ResponseEntity<User> getUserById(String id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent())
		{
			return ResponseEntity.ok(user.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}

	@Override
	public ResponseEntity<List<User>> getAllUsers(Integer page, Integer size) {
		
		if(page<0 || size<1)
		{
			return ResponseEntity.badRequest().build();
		}
		if(size>1000)
		{
			size=1000;
		}
		Pageable pageable=PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "name"));
//		Slice<User> users=userRepository.findAll(pageable);
		Page<User> users=userRepository.findAll(pageable);
		
		return ResponseEntity.ok(users.getContent());
		
	}
	
	

}
