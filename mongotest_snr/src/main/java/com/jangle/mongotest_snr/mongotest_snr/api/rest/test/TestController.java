package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/tests", produces = "application/json")
public class TestController {
	
	private final TestService testService;
	
	public TestController(TestService testService) {
		this.testService =testService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TestDocument> getById(@PathVariable String id) throws TestException {
		TestDocument testDocument = testService.getById(id);
		 return ResponseEntity.ok(testDocument);
	}
	

}
