package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.batch.SpringBatchExtensionApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("loc")
@SpringApplicationConfiguration(classes = SpringBatchExtensionApplication.class)
public class SpringBatchExtensionApplicationTests {

	@Test
	public void contextLoads() {
	}

}
