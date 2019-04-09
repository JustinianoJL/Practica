package com.spring.boot;

import java.util.Arrays;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.spring.boot.model.Cliente;
import com.spring.boot.modelo.entities.Multa;

@SpringBootApplication
public class MultasWebApplication
{

	public static void main(String[] args)
	{
		//SpringApplication.run(MultasWebApplication.class, args);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Multa[]> httpEntityMultas = new HttpEntity<Multa[]>(headers);
		HttpEntity<Cliente[]> httpEntityClientes = new HttpEntity<Cliente[]>(headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Multa[]> response = 
				template.exchange(
						"http://localhost:8080/multas", 
						HttpMethod.GET,
						httpEntityMultas,
						Multa[].class);
		HttpStatus statusCode = response.getStatusCode();
		
		if(statusCode == HttpStatus.OK)
		{
			Multa[] multas = response.getBody();
			if(multas != null)
			{
				for(Multa multa : multas)
				{
					System.out.println(multa.getMatricula());
				}
			}
		}
	}
}
