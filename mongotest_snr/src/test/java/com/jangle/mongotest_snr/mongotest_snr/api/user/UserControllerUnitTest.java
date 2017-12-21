package com.jangle.mongotest_snr.mongotest_snr.api.user;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerUnitTest {


    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;
    
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
              //  .addFilters(new CORSFilter())
                .build();
    }
    
    @Test
    public void test_get_all_success() throws Exception {
       
    }

}
