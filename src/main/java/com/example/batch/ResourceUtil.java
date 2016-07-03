package com.example.batch;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;

public class ResourceUtil {

	public static Resource getResource(final String resourcePath) {
		if (resourcePath == null) {
			return null;
		}
		
		Resource resource = null;
		String profile = System.getProperty("spring.profiles.active");
		if (!StringUtils.hasText(profile) || "local".equals(profile)) {
			resource = new ClassPathResource(resourcePath);
			return resource;
		}
		
		try {
			resource = new UrlResource(resourcePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resource;
	}
}
