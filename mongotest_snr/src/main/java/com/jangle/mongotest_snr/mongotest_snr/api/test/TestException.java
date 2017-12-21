package com.jangle.mongotest_snr.mongotest_snr.api.test;

public class TestException  extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public TestException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public TestException() {
		super();
	}
}