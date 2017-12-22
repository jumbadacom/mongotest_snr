package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jangle.mongotest_snr.mongotest_snr.MongotestSnrApplication;
import com.jangle.mongotest_snr.mongotest_snr.api.enums.Type;
import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.Jangle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongotestSnrApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JangleIntegrationTest1 {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	private HttpHeaders headers = new HttpHeaders();
	
	
	@Test
	public void testCreateJangle() throws Exception { 
		log.info("test : jangle");
		headers.set(HttpHeaders.CONNECTION, "keep-alive");
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		
	    Jangle jangle=getTestJangle();
		String uriToCreateJangle = "/api/jangles";
		log.info("test path : "+formFullURLWithPort(uriToCreateJangle));
		String inputInJson = this.mapToJson(jangle);
		HttpEntity<Jangle> doc = new HttpEntity<Jangle>(jangle, headers);
		ResponseEntity<Jangle> response = testRestTemplate.exchange(
				formFullURLWithPort(uriToCreateJangle),
				HttpMethod.POST, doc, Jangle.class);
		Jangle responseInJson = response.getBody();
		log.info("test response code : "+response.getStatusCode());
		log.info("test response : "+responseInJson);
		//assertThat(responseInJson).isEqualTo(inputInJson);
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
	
	
	
	
	/**
	 * this utility method Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

    /**
     * This utility method to create the url for given uri. It appends the RANDOM_PORT generated port
     */
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}


