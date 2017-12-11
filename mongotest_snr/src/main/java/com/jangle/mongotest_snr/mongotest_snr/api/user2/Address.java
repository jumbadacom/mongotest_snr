package com.jangle.mongotest_snr.mongotest_snr.api.user2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
	
	private String name;
	
	private Long postalCode;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private String country;
	
	private double[] location;
	

}
