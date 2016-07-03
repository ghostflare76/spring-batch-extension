package com.example.batch.config;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.batch.listener.CustomJobExecutionListener;

@Configuration
@PropertySource("job.properties")
public class JobConfig {
	
	@Bean
	public JobExecutionListener listener() {
		return new CustomJobExecutionListener();
	}

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
	    JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
	    jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
	    return jobRegistryBeanPostProcessor;
	}

}
