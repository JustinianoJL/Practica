package com.spring.boot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.model.Cliente;
import com.spring.boot.model.ClienteRepository;

@Configuration
public class Configuracion {
	
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(ClienteRepository repo) {
		return args -> {
			repo.save(new Cliente("Ruben", "Metepalos", "Calle nueva" ));
			repo.save(new Cliente("Paco", "Malasangre", "Calle vieja"));
			repo.save(new Cliente("Antonia", "Piesgrandes", "Calle de arrriba"));
		};
	}

}
