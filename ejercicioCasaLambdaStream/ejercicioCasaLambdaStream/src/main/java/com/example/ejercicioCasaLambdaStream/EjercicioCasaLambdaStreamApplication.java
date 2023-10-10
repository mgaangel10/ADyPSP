package com.example.ejercicioCasaLambdaStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EjercicioCasaLambdaStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCasaLambdaStreamApplication.class, args);

		List<String> palabras = new ArrayList<String>();
		palabras.add("alpha");
		palabras.add("bravo");
		palabras.add("charlie");
		palabras.add("delta");
		palabras.add("echo");
		palabras.add("foxtrot");

		String cadena = palabras.stream()
				.map(palabra -> palabra.substring(0, 1))
				.collect(Collectors.joining());

		System.out.println(cadena);
		palabras.removeIf(a -> a.length() %2 !=0);

		System.out.println(palabras);
		Map<String,String> mapa = new HashMap<>();
		mapa.put("clave1","valor1");
		mapa.put("clave2","valor2");
		mapa.put("clave3","valor3");

		List<String> lista = mapa.entrySet().stream()
				.map(entrada -> entrada.getKey()+","+entrada.getValue())
				.collect(Collectors.toList());
		System.out.println(lista);


	}


}
