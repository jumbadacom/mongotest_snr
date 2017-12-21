package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class JangleServiceTestImpl {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;
	private HttpHeaders headers = new HttpHeaders();

	@InjectMocks
	JangleTestService jangleTestService;

	
	public void b() throws Exception {
		log.info("test : jangle b");
		ResponseEntity<Jangle> response=	jangleTestService.getById("5a3903b9dcf7c604d460f927");
		Jangle responseJangle = response.getBody();
		log.info("test response : "+responseJangle);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertThat(new ObjectId("5a3903b9dcf7c604d460f927")).isEqualTo(responseJangle.getId());
	}
	
	@Test
	public void a() {
		log.info("test : jangle a");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.set(HttpHeaders.CONNECTION, "keep-alive");
		headers.setContentType(MediaType.APPLICATION_JSON);
		String uriToCreateJangle = "/api/jangles/5a39047fdcf7c604d48ebfe6";
		log.info("test path : " + formFullURLWithPort(uriToCreateJangle));
		HttpEntity<Jangle> doc = new HttpEntity<Jangle>(null, headers);
		ResponseEntity<Jangle> response = testRestTemplate.exchange(formFullURLWithPort(uriToCreateJangle),
				HttpMethod.GET, doc, Jangle.class);
		Jangle responseJangle = response.getBody();
		
		log.info("test response : "+response);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		log.info("test response body : "+response.getBody());
		//assertThat(new ObjectId("5a3903b9dcf7c604d46187de")).isEqualTo(responseJangle.getId());
	}

	/**
	 * this utility method Maps an Object into a JSON String. Uses a Jackson
	 * ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	/**
	 * This utility method to create the url for given uri. It appends the
	 * RANDOM_PORT generated port
	 */
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
