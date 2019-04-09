package com.spring.boot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.modelo.entities.Multa;
import com.spring.boot.modelo.entities.MultaRepository;

@Configuration
public class ConfiguracionMulta
{
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MultaRepository repo)
	{
		return args -> {
			repo.save(new Multa("1111 aaa","Exceso de Velocidad",250));
			repo.save(new Multa("1111 aaa","Embriaguez",145));
			repo.save(new Multa("1111 aaa","Saltar Luz roja",185));
			repo.save(new Multa("1111 aaa","Luz de Freno averiada",140));
			
			repo.save(new Multa("2222 bbb","Exceso de Velocidad",300));
			repo.save(new Multa("2222 bbb","Embriaguez",120));
			repo.save(new Multa("2222 bbb","Saltar Luz roja",95));
			repo.save(new Multa("2222 bbb","Luz de Freno averiada",165));
			
			repo.save(new Multa("3333 ccc","Exceso de Velocidad",200));
			repo.save(new Multa("3333 ccc","Embriaguez",225));
			repo.save(new Multa("3333 ccc","Saltar Luz roja",155));
			repo.save(new Multa("3333 ccc","Luz de Freno averiada",100));
		};
	}
}
