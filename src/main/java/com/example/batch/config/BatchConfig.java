package com.example.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:batch-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableBatchProcessing(modular = true)
public class BatchConfig {

}
