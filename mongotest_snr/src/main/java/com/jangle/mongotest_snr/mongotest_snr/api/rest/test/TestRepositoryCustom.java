package com.jangle.mongotest_snr.mongotest_snr.api.rest.test;

import java.util.Optional;

public interface TestRepositoryCustom {
	
	boolean updateTestDocumentByName(String id,String name);

	boolean updateTestDocumentAsPassive(String id);
}
