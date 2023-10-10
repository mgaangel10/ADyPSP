package com.example.repasoExamen.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String codigoPais;
    private String direccion;
    private String localidad;
    private String localizacion;
    private List<String> imagenes;
    @ManyToMany
    private Categoria categoria;

}
