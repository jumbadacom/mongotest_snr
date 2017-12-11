package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;


	@Override
	public ResponseEntity<User> getCommentById(String id) {
		Optional<User> optUser = userRepository.findById(id);
		if (!optUser.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(optUser.get());
	}

	@Override
	public ResponseEntity<List<User>> getAllComments(Integer page, Integer size){
		 
		return null;
	}

	@Override
	public ResponseEntity<Void> save(User user) {
		User sonuc = userRepository.insert(user);
		if (sonuc != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@Override
	public ResponseEntity<Void> delete(String id) throws java.lang.IllegalArgumentException {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> update(String id, User comment) {
		
		Optional<User> optUser=userRepository.findById(id);
		if(!optUser.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		User temp=optUser.get();
		
		
		if (temp != null) {
			return ResponseEntity.created(null).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	
}
