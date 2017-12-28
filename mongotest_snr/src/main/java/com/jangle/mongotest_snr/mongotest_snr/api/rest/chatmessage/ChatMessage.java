package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
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
@Document(collection="chatmessage")
@CompoundIndexes({
    @CompoundIndex(name = "registeredTime_toUserId", def = "{'registeredTime':-1, 'toUserId': 1}",sparse=true,background=true)
})
public class ChatMessage {
	
	@Id
	@JsonProperty
	private ObjectId id=null;
	
	@Indexed(unique=false,background=true,sparse=true)
	@NotNull
	@JsonProperty
	private ObjectId fromUserId=null;

	@Indexed(unique=false,background=true,sparse=true)
	@NotNull
	@JsonProperty
	private ObjectId toUserId=null;
		
	@NotNull
	@JsonProperty
	private Boolean passive = false;
	
	@JsonProperty
	@TextIndexed
	@Indexed(unique=false,background=true,sparse=true)
	private String message;
	
	@NotNull
	@JsonProperty
	private Boolean toUserIdWasSee = false;
	
	@Indexed(unique=false,background=true,sparse=true)
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime registeredTime = LocalDateTime.now();
	
	@JsonProperty
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedTime=null;
	
	
	
}
