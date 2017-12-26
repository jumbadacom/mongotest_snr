package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.jangle.mongotest_snr.mongotest_snr.api.rest.jangle.JangleService;

@Profile("test")
@Configuration
public class TestConfiguration {
	
    @Bean
    @Primary
    public JangleService jangleServiceClient() {
        return mock(JangleService.class);
    }
}
