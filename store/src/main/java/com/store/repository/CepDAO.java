package com.store.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CepDAO {

	public boolean validZipCode(String zipCode) {
		
		StringBuilder uri = new StringBuilder();
		uri.append("https://viacep.com.br/ws/")
		.append(zipCode)
		.append("/json/");
				
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri.toString(), String.class);
		return !result.contains("erro");
	}
}
