package com.example.batch;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBatchExtensionApplicationTests;

public class JobTest extends SpringBatchExtensionApplicationTests {
	
	protected static Logger log = LoggerFactory.getLogger(JobTest.class);
	
	@Autowired
	private JobRegistry jobRegistry;

	@Autowired
	private JobLauncher jobLauncher;

	private JobParameters jobParameter;

	@Before
	public void setup() {
		jobParameter = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
	}

	@Test
	public void AccessoryJobTest() throws Exception {		
		Job job = jobRegistry.getJob("accessoryXmlJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameter);
		log.info("AccessoryJobTest : {}", jobExecution.getStatus());
		log.info("BatchStatus : {}", BatchStatus.COMPLETED);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));
	}
	
	@Test
	public void WeaponJobTest() throws Exception {		
		Job job = jobRegistry.getJob("weaponDbToPrintJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameter);
		log.info("weaponDbToPrintJob : {}", jobExecution.getStatus());
		log.info("BatchStatus : {}", BatchStatus.COMPLETED);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));
	}
	
	
}
