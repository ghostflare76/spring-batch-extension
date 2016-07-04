package com.example.batch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:jpa-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
public class JpaConfig {

}
