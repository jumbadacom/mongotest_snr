package com.jangle.mongotest_snr.mongotest_snr.api.exception;

public enum ExceptionMessage {
	
	DOCUMENT_NOT_EXIST("Document doesn't exist"),UNSUITABLE_PATH_VARIABLE("Unsuitable path variable(s)"),UNSUITABLE_REQUEST_PARAM("Unsuitable Request parameter(s)"),DELETING_FAILED("Deleting the document is failed.");
	
	private String value;
	
	private ExceptionMessage(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	

}
