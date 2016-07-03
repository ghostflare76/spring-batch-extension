package com.example.batch.job;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.listener.LogProcessListener;
import com.example.batch.model.Accessory;
import com.example.batch.model.Weapon;
import com.example.batch.model.WeaponBackup;
import com.example.batch.processor.WeaponJobProcessor;

@Configuration
public class WeaponJob {
	
	@Autowired
	private StepBuilderFactory stepBuilders;

	@Autowired
	private JobBuilderFactory jobBuilders;

	@Autowired
	private EntityManagerFactory emf;

	@Autowired
	private JobExecutionListener listener;

	@Bean(name = "weaponReader", destroyMethod = "")
	public ItemReader<Weapon> reader() {
		JpaPagingItemReader<Weapon> reader = new JpaPagingItemReader<Weapon>();
		reader.setEntityManagerFactory(emf);
		reader.setQueryString("select w FROM Weapon w");	
		reader.setPageSize(420);
		return reader;
	}

	@Bean(name = "weaponDbToPrintJob")
	public Job job() {
		return jobBuilders.get("weaponDbToPrintJob")
			.listener(listener)
			.start(step()).build();
	}

	@Bean(name = "weaponStep")
	public Step step() {
		return stepBuilders.get("weaponStep").<Weapon, WeaponBackup> chunk(420)
			.reader(reader())
			.processor(new WeaponJobProcessor())
			.listener(logProcessListener())		
			.writer(writer())
			.build();
	}
	
	@Bean(name = "weaponWriter")
	public ItemWriter<WeaponBackup> writer() {
		JpaItemWriter<WeaponBackup> writer = new JpaItemWriter<WeaponBackup>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}

	@Bean
	public LogProcessListener logProcessListener(){
		return new LogProcessListener();
	}    
}
