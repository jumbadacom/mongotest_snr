package com.jangle.mongotest_snr.mongotest_snr.api.rest.comment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="comments")
public class Comment {
	
	@Id
	private String id;
	@Indexed
	private String commentUserId;
	@Indexed
	private String sharedId;
	private Long likeCount;
	private String text;
	private Boolean isDeleted;	
	private String extra1;
	private String extra2;
	private String extra3;
	private String extra4;
	private String extra5;

	

}
