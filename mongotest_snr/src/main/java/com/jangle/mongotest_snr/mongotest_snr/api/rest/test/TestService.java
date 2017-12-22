package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.List;
import java.util.Optional;

public interface TestService {
	
	List<TestDocument> getTestDocuments(int page,int size)  throws TestException,Exception;
	
	TestDocument getById(String id)  throws TestException;
	
	void saveTestDocument(TestDocument testDocument);
	
	void updateTestDocument(String id,TestDocument testDocument)throws TestException;
	
	void updateTestDocumentByName(String id,String name)throws TestException;
	
	void deleteTestDocumentById(String id)throws TestException;

}
