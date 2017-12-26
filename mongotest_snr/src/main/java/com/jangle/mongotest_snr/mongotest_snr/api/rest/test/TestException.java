package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jangle.mongotest_snr.mongotest_snr.api.exception.ExceptionMessage;


@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class TestException  extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public TestException(ExceptionMessage errorMessage) {
		super(errorMessage.getValue());
		this.errorMessage = errorMessage.getValue();
	}

	public TestException() {
		super();
	}
}