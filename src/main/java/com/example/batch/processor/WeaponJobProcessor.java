package com.example.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.batch.model.Weapon;
import com.example.batch.model.WeaponBackup;

public class WeaponJobProcessor implements ItemProcessor<Weapon, WeaponBackup> {

	protected static Logger log = LoggerFactory.getLogger(WeaponJobProcessor.class);
		
	@Override
	public WeaponBackup process(final Weapon item) throws Exception {	
		WeaponBackup backup = new WeaponBackup();
		backup.setId(item.getId());
		backup.setName(item.getName());

		return backup;
	}

}
