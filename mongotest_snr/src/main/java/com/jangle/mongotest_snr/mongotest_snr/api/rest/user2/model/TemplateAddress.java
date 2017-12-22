package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemplateAddress {
	
	private String name;
	
	private Long postalCode;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private String country;
	
	private double[] location;
	

}
