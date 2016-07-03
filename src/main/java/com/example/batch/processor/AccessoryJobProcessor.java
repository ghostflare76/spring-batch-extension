package com.example.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.batch.model.Accessory;

public class AccessoryJobProcessor implements ItemProcessor<Accessory, Accessory> {

	protected static Logger log = LoggerFactory.getLogger(AccessoryJobProcessor.class);
	
	@Override
	public Accessory process(final Accessory item) throws Exception {
		log.info("Accessory processor : {}", item);
		return item;
	}

}
