package me.dio.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot que demonstra alguns padrões de projetos
 * implementados pelo Spring Framework.
 * Possui os seguintes módulos:
 * - Spring Web
 * - Spring Data JPA
 * - OpenAPI/Swagger
 * - H2 Database
 * - OpenFeign
 * - Lombok
 *
 * @author alanvribeiro
 */
@EnableFeignClients
@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
	}

}
