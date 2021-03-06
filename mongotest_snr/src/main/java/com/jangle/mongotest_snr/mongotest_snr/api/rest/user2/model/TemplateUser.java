package com.jangle.mongotest_snr.mongotest_snr.api.rest.user2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="appusers")
public class TemplateUser {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String userName;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDateTime birthDate;
	
	private Boolean isActive;
	
	private String name;
	
	@Indexed(unique=true)
	private String email;
	
	private String lastName;

	@JsonProperty
	private List<TemplateAddress> addresses =new ArrayList<>();

	public TemplateUser(String userName, LocalDateTime birthDate, Boolean isActive, String name, String email,
			String lastName, List<TemplateAddress> addresses) {
		super();
		this.userName = userName;
		this.birthDate = birthDate;
		this.isActive = isActive;
		this.name = name;
		this.email = email;
		this.lastName = lastName;
		this.addresses = addresses;
	}


	

	


	
	
	
	


}
