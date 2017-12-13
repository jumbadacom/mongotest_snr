package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Document(collection="jangles")
public class Jangle {
	
	@Id
	private String id=null;
	
	@Indexed(unique=false,background=true,sparse=true)
	@NotNull
	private String userId=null;

	@Indexed(unique=false,background=true,sparse=true)
	@JsonProperty
	private Type type=null;
	
	@JsonProperty
	private List<String> likeUserId = new ArrayList<>();
	
	@JsonProperty
	private List<String> hideUserId = new ArrayList<>();
	
	@JsonProperty
	private List<String> sharedUserId = new ArrayList<>();
	
	@NotNull
	@JsonProperty
	private Boolean passive = false;
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime registeredTime = LocalDateTime.now();
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedTime=null;
	
	@JsonProperty
	@Size(min=1,max=128)
	private List<String> tags = new ArrayList<>();
}
