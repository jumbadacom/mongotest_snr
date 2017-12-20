package com.jangle.mongotest_snr.mongotest_snr.api.jangle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
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
@CompoundIndexes({
    @CompoundIndex(name = "registeredTime_type", def = "{'registeredTime':1, 'type': 1, 'tags':1}",sparse=true,background=true)
})
public class Jangle {
	
	@Id
	private ObjectId id=null;
	
	@Indexed(unique=false,background=true,sparse=true)
	@NotNull
	private ObjectId userId=null;

//	@Indexed(unique=false,background=true,sparse=true)
	@JsonProperty
	private Type type=null;
	
	@JsonProperty
	private List<ObjectId> likeUserId = new ArrayList<>();
	
	@NotNull
	@JsonProperty
	private Integer likeCount = 0;
	
	@JsonProperty
	private List<ObjectId> hideUserId = new ArrayList<>();
	
	@NotNull
	@JsonProperty
	private Integer hideCount = 0;
	
	@JsonProperty
	private List<ObjectId> sharedUserId = new ArrayList<>();
	
	@NotNull
	@JsonProperty
	private Integer shareCount = 0;
	
	@NotNull
	@JsonProperty
	private Integer viewCount = 0;
	
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
	@Size(min=1,max=255)
	private List<String> tags = new ArrayList<>();
	
	
}
