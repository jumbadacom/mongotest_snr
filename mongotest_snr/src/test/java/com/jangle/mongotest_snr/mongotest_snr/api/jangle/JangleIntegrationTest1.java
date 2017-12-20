package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.assertj.core.api.Assertions.assertThat;


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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jangle.mongotest_snr.mongotest_snr.MongotestSnrApplication;

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
		log.info("test jangle");
		Jangle j = new Jangle();
		j.setLikeCount(55);
		j.setHideCount(4);
		j.setPassive(false);
		j.setShareCount(444);
		j.setViewCount(1111);
	
		String uriToCreateJangle = "/api/jangles";
		String inputInJson = this.mapToJson(j);
		
		HttpEntity<Jangle> entity = new HttpEntity<Jangle>(j, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(
				formFullURLWithPort(uriToCreateJangle),
				HttpMethod.POST, entity, String.class);
		String responseInJson = response.getBody();
		assertThat(responseInJson).isEqualTo(inputInJson);
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


