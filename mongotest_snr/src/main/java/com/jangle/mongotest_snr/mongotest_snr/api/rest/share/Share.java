package com.jangle.mongotest_snr.mongotest_snr.api.rest.share;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="shares")
public class Share {

	
	@Id
	private String id;
	@Indexed
	private String authorUserId;
	private Long likeCount;
	private String text;
	private String[] tags;
	private Boolean isDeleted;
	private String extra1;
	private String extra2;
	private String extra3;
	
	public Share(String authorUserId, Long likeCount, String text,  String[] tags,
			Boolean isDeleted, String extra1, String extra2, String extra3) {
		super();
		this.authorUserId = authorUserId;
		this.likeCount = likeCount;
		this.text = text;
		this.tags = tags;
		this.isDeleted = isDeleted;
		this.extra1 = extra1;
		this.extra2 = extra2;
		this.extra3 = extra3;
	}
	
	
	
	
}
