package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.JangleService;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoServiceTest {
	
	  @InjectMocks
	    private JangleService jangleService;
	  
	  public void getById() {
		  
		  
	  }

}
