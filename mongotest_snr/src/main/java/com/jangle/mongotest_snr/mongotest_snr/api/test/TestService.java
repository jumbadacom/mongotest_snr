package com.jangle.mongotest_snr.mongotest_snr.api.test;

import java.util.Optional;

public interface TestService {
	
	Optional<Test> getById(String id);

}
