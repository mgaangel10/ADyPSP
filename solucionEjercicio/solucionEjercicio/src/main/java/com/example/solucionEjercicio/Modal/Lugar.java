package com.example.solucionEjercicio.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lugar {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nombre;
    private String url;
    private String localizacion;
    private String descripcion;
    private String tags;
}
