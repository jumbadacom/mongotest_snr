package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.springframework.core.env.AbstractEnvironment.*;

import java.util.logging.LogRecord;

import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.*;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class JangleTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void ensureInsertWorks() {
		 log.info("test");
		 Jangle jangle = new Jangle();
		 jangle.setPassive(true);
		 jangle.setUserId(new ObjectId("5a3903b9dcf7c604d46137ad"));
		 ResponseEntity<Jangle> responseEntity = restTemplate.postForEntity("api/jangle", jangle,Jangle.class);
		 Jangle jangleReturned = responseEntity.getBody();
		 assertNotNull("Should have an PK", jangleReturned.getId());
		 
		 
		 
	}

}
