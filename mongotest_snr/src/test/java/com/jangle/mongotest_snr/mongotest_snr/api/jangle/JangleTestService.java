package com.jangle.mongotest_snr.mongotest_snr.api.jangle;


import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.Jangle;
import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.JangleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JangleTestService {
	
	

	    @InjectMocks
	    private JangleService jangleService;
	    
	    public ResponseEntity<Jangle> getById(String id) {
	    	log.info("test");
	    	return jangleService.getById(id);
	    }

}
