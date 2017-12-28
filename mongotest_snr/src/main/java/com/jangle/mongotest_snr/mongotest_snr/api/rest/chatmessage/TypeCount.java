package com.jangle.mongotest_snr.mongotest_snr.api.rest.chatmessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeCount {
	private String hosting;
	private long total;
}
