package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.springframework.core.env.AbstractEnvironment.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.LogRecord;

import javax.swing.ListModel;

import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.*;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
	private HttpHeaders headers = new HttpHeaders();
	
	@LocalServerPort
	private int port;
	
	@Test
	public void ensureInsertWorks() throws Exception {
		log.info("test : jangle");
		headers.set(HttpHeaders.CONNECTION, "keep-alive");
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		 Jangle jangle =getTestJangle();
		HttpEntity<Jangle> doc = new HttpEntity<Jangle>(jangle, headers);
		
		
		 ResponseEntity<Jangle> responseEntity = restTemplate.postForEntity(formFullURLWithPort("api/jangles"), doc,Jangle.class);
		 Jangle jangleReturned = responseEntity.getBody();
		 log.info("test response : "+jangleReturned);
		 assertNotNull("Should have an PK", jangleReturned.getId());
		 
		 
		 
	
	}
	
	private Jangle getTestJangle() {
		Jangle j = new Jangle();
		List<ObjectId> list = new ArrayList<>();
		list.add(new ObjectId("5a39047fdcf7c604d48ebfe7"));
		
		j.setId(new ObjectId());
		j.setUserId(new ObjectId("5a3903b9dcf7c604d460f926"));
		j.setType(Type.SOUND);
		j.setLikeUserId(list);
		j.setLikeCount(55);
		j.setHideUserId (list);
		j.setHideCount(4);
		j.setSharedUserId(new ArrayList<>());
		j.setShareCount(44);
		j.setViewCount(new Random().nextInt(500));
		j.setPassive(false);
		Calendar takvim=Calendar.getInstance();
		takvim.add(Calendar.DAY_OF_MONTH, new Random().nextInt(900)*-1);
		j.setRegisteredTime(LocalDateTime.ofInstant(takvim.toInstant(), ZoneId.systemDefault()));
		j.setTags(Arrays.asList(new String[] {"test"+new Random().nextInt(1000),"deneme-"+new Random().nextInt(1000)}));
		return j;
	}
	
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
