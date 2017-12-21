package com.jangle.mongotest_snr.mongotest_snr.api.test;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

	private final TestRepository testRepository;

	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public Optional<Test> getById(String id) {
		// TODO Auto-generated method stub
		return testRepository.findById(id);
	}

}
