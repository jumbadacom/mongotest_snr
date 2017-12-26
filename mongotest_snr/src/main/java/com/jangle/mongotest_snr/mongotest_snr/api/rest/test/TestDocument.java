package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({ "id", "name", "count" ,"is_passive"})
@Document(collection = "test")
public class TestDocument {

	
	@Id
	@JsonProperty
	private String id;
	@NotEmpty
	@Size(min = 4, max = 20)
	@Indexed(unique = true)
	@JsonProperty
	private String name;
	@NotNull
	@JsonProperty
	private Long count;
	@NotNull
	@Field("is_passive")
	@JsonProperty
	private Boolean isPassive;
	
	public TestDocument(@NotEmpty @Size(min = 4, max = 20) String name, @NotEmpty Long count,Boolean isPassive) {
		super();
		this.name = name;
		this.count = count;
		this.isPassive = isPassive;
	}
	
	
	

}
