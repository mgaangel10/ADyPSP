package com.example.ejemplodtoyRecord.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moumento {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String codigoPais;
    private String direcion;
    private String locacion;
    private String urbanizacion;
    private String[] imagenes;

    @ManyToMany
    private Ruta ruta;

    @ManyToMany
    private Categoria categoria;
}
