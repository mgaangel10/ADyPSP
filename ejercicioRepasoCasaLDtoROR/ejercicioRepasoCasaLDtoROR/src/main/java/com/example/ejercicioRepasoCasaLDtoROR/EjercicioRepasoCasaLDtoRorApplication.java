package com.example.ejercicioRepasoCasaLDtoROR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import humanize.Humanize;
@SpringBootApplication
public class EjercicioRepasoCasaLDtoRorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepasoCasaLDtoRorApplication.class, args);
		int tiempo = 3600;  // tiempo en minutos

		String resultado = Humanize.duration(tiempo);  // convierte a segundos

		System.out.println(resultado);
	}

}
