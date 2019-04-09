package com.spring.boot.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.spring.boot.modelo.entities"})

@EnableTransactionManagement
public class ConfiguracionJPA {
	/*
	 * Con el DataSource me permite obtener conexiones de forma eficiente
	 * No cierra conexiones, las devueve a su almacen (pool)
	 * Guarda una caché de sentencias precompiladas (LRU normalmente. Last Recently Used.)
	 * Evita asfixiar la base de datos ya que pone límite al numero de conexiones.
	 * Esta mal hacerlo desde la app, pero peor sería conectar con Connection conn = new Connection()
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// Clase para realizar las conexiones
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// La cadena de conexion. Que es distinta para cada base de datos.
		StringBuilder constructorDeCadenas = new StringBuilder("jdbc:mysql://localhost:3306/test");
									//driver:nombre://ruta:puerto/bbdd
		constructorDeCadenas.append("?useUnicode=true");
		constructorDeCadenas.append("&useJDBCCompliantTimezoneShift=true");
		constructorDeCadenas.append("&useLegacyDatetimeCode=false");
		constructorDeCadenas.append("&serverTimezone=UTC");
		
		dataSource.setUrl(constructorDeCadenas.toString());
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			Environment env) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		// Implementación que gestionará la base de datos, la que genera las sentencias
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// Donde se encuentran los objetos que hay que persistir
		factoryBean.setPackagesToScan("com.curso.java.spring.jpa.model.entities");
		Properties jpaProperties = new Properties();
		// Dialecto a utilizar dependiente de la base de datos y su versión
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		// DDL Data Definition Language Construcción de tablas.
		jpaProperties.put("hibernate.hbm2ddl.auto","update");// create-drop validate
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql","false");
		factoryBean.setJpaProperties(jpaProperties);
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		return manager;
	}
}














