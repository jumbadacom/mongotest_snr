package com.jangle.mongotest_snr.mongotest_snr.api.test;

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
	public ResponseEntity<Test> getById(@PathVariable String id) {
		Optional<Test> optTest = testService.getById(id);
		if (optTest.isPresent()) {
			 return ResponseEntity.ok(optTest.get());
		}
		return  ResponseEntity.notFound().build();
	}
	

}
