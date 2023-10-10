package com.example.ejemploDTO.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {
    @Id
    @GeneratedValue
    private Long id;
    private String codigoPais , ciudad,pais,locaclizacion,nombre,url;
    @ManyToMany
    private Categoria categoria ;
}
