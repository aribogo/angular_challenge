package com.store.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CpfDAO {
	
	private final String TOKEN = "346|iE8VROheRlXGSN6mQg9fIjERWOgKoJzs";
	
	/**
	 * Consumes CPF validator API from invertexto.com
	 * @param cpf
	 * @return
	 */
	public boolean getCpf(String cpf) {
		
		StringBuilder uri = new StringBuilder();
		uri.append("https://api.invertexto.com/v1/validator?type=cpf&value=")
		.append(cpf)
		.append("&token=")
		.append(TOKEN);
				
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri.toString(), String.class);
		return result.contains("true");
	}
	
}
