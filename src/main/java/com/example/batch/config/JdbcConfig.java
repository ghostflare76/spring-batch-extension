package com.example.batch.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"} )
public class JdbcConfig {
	

}
