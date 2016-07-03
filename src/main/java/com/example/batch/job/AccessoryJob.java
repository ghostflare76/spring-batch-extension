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
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.batch.ResourceUtil;
import com.example.batch.model.Accessory;
import com.example.batch.processor.AccessoryJobProcessor;

@Configuration
public class AccessoryJob {
	
	@Autowired
	private StepBuilderFactory stepBuilders;

	@Autowired
	private JobBuilderFactory jobBuilders;

	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private JobExecutionListener listener;

	@Bean(name = "accessoryXmlReader")
	public ItemReader<Accessory> reader() {
		StaxEventItemReader<Accessory> reader = new StaxEventItemReader<Accessory>();
		String resourcePath = environment.getRequiredProperty("resource.input.accessory");	
		Resource resource = ResourceUtil.getResource(resourcePath);	
		reader.setResource(resource); 		
		reader.setFragmentRootElementName("item");
		reader.setUnmarshaller(itemMarshaller());
		return reader;
	}

	@Bean(name = "accessoryMarshaller")
	public Unmarshaller itemMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Accessory.class);
		return marshaller;
	}

	@Bean(name = "accessoryXmlJob")
	public Job job() {
		return jobBuilders.get("accessoryXmlJob")
			.listener(listener)
			.start(step()).build();
	}

	@Bean(name = "accessoryXmlToDbStep")
	public Step step() {
		return stepBuilders.get("accessoryXmlToDbStep").<Accessory, Accessory> chunk(20)
			.reader(reader())
			.processor(new AccessoryJobProcessor())
			.writer(writer())
			.build();
	}

	@Bean(name = "accessoryDbWriter")
	public ItemWriter<Accessory> writer() {
		JpaItemWriter<Accessory> writer = new JpaItemWriter<Accessory>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}
}
