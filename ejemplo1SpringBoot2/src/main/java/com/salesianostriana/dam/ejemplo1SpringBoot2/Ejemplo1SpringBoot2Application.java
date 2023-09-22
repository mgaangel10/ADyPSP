package com.salesianostriana.dam.ejemplo1SpringBoot2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejemplo1SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo1SpringBoot2Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(Service service) {
		return args -> {
			service.escribir();
		};

	}
}
