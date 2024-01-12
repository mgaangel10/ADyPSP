package com.example.test2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double precio;
    private boolean disponible;
}
