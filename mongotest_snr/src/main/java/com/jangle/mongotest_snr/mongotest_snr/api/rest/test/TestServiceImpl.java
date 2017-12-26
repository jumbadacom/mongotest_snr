package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jangle.mongotest_snr.mongotest_snr.api.exception.ExceptionMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

	private final TestRepository testRepository;

	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}
	

	@Override
	public TestDocument getById(String id) throws TestException{
		// TODO Auto-generated method stub
		Optional<TestDocument> opt = testRepository.findById(id);
		if(!opt.isPresent()) {
			throw new TestException(ExceptionMessage.DOCUMENT_NOT_EXIST);
		}
		return opt.get();
		
	}


	@Override
	public List<TestDocument> getTestDocuments(int page, int size) throws TestException, Exception {
		if (page<0||size<1||size>100) {
			throw new TestException(ExceptionMessage.UNSUITABLE_PATH_VARIABLE);
		}
		return null;
	}


	@Override
	public void saveTestDocument(TestDocument testDocument) {
		// TODO Auto-generated method stub
		testRepository.save(testDocument);
		
	}


	@Override
	public void updateTestDocument(String id,TestDocument testDocument) throws TestException{
		// TODO Auto-generated method stub
		Optional<TestDocument> opt =testRepository.findById(id);
		if(!opt.isPresent()) {
			throw new TestException(ExceptionMessage.DOCUMENT_NOT_EXIST);
		}
		testRepository.save(testDocument);
	}


	@Override
	public void updateTestDocumentByName(String id, String name) throws TestException {
		// TODO Auto-generated method stub
		if(!testRepository.updateTestDocumentByName(id, name)) {
			throw new TestException(ExceptionMessage.DOCUMENT_NOT_EXIST);
		}
		
	}


	@Override
	public void deleteTestDocumentById(String id) throws TestException {
		// TODO Auto-generated method stub
		if(!testRepository.updateTestDocumentAsPassive(id)) {
			throw new TestException(ExceptionMessage.DELETING_FAILED);
		}
	}


	

}
