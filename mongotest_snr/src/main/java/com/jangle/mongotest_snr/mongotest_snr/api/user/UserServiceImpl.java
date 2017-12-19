package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}

	@Override
	public ResponseEntity<User> getById(String id) {
		Optional<User> optUser = userRepository.findById(id);
		if (!optUser.isPresent())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(optUser.get());
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

	@Override
	public ResponseEntity<Void> insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<User> login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> logout(User user) {
		
		return null;
	}

	@Override
	public ResponseEntity<List<User>> getFriends(String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<User> liste = userRepository.getFriends(pageable, userId);
		
		if(liste!=null && !liste.isEmpty())
		{
			return ResponseEntity.ok(liste);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}

	@Override
	public ResponseEntity<List<User>> getFollowedUsers(String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<User> liste = userRepository.getFollowedUsers(pageable, userId);
		
		if(liste!=null && !liste.isEmpty())
		{
			return ResponseEntity.ok(liste);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<User>> getFollowerUsers(String userId) {
		Pageable pageable=PageRequest.of(0, 25, new Sort(Sort.Direction.DESC, "id"));
		List<User> liste = userRepository.getFollowerUsers(pageable, userId);
		
		if(liste!=null && !liste.isEmpty())
		{
			return ResponseEntity.ok(liste);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	
}
