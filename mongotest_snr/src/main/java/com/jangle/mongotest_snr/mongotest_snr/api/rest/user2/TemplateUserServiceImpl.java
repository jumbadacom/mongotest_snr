package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model.TemplateUser;

@Service
public class TemplateUserServiceImpl implements TemplateUserService{
	
	
	
	private TemplateUserRepository userRepository;
	
	public TemplateUserServiceImpl(TemplateUserRepository userRepository)
	{
		this.userRepository=userRepository;
	}


	@Override
	public ResponseEntity<TemplateUser> getUserById(String id) {
		Optional<TemplateUser> user=userRepository.findById(id);
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
	public ResponseEntity<List<TemplateUser>> getAllUsers(Integer page, Integer size) {
		
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
		Page<TemplateUser> users=userRepository.findAll(pageable);
		
		return ResponseEntity.ok(users.getContent());
		
	}
	
	

}
