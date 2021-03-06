package com.jangle.mongotest_snr.mongotest_snr.api.rest.user.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
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
@Document(collection="users")
public class User {
	
	@Id
	private ObjectId id;
	
	@Indexed(unique=true,background=true,sparse=true,direction=IndexDirection.ASCENDING)
	@Size(min=4,max=255)
	private String userName;
	
	@JsonProperty
	private String password;
	
	@Indexed(unique=false,background=true,sparse=true,direction=IndexDirection.ASCENDING)
	@JsonProperty
	private String name;
	
	
	@Indexed(unique=true,background=true,sparse=true,direction=IndexDirection.ASCENDING)
	@JsonProperty
	private String email;
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastLogout;

	@Indexed(unique=false,background=true,sparse=true,direction=IndexDirection.DESCENDING)
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDateTime birtdate;
	
	@JsonProperty
	private String address;
	
	@NotNull
	@JsonProperty
	private Boolean passive = false;
	
	@NotNull
	@JsonProperty
	private Boolean emailVerified = false;
	
	@Indexed(unique=false,background=true,sparse=true,direction=IndexDirection.DESCENDING)
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime registeredTime;
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedTime;
	
	@Indexed(unique=false,background=true,sparse=true,direction=IndexDirection.DESCENDING)
	@JsonProperty
	private List<ObjectId> friendUserId=new ArrayList<>();
	
	@JsonProperty
	private Integer friendUserCount;
	
	@Indexed(unique=false,background=true,sparse=true,direction=IndexDirection.DESCENDING)
	@JsonProperty
	private List<ObjectId> followedUserId=new ArrayList<>();
	
	@JsonProperty
	private Integer followedUserCount;
	
	@JsonProperty
	private Integer followerUserCount;
	
	
	

	
}
