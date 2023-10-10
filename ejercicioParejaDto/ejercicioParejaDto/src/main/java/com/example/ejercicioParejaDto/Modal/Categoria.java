package com.example.ejercicioParejaDto.Modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Categoria {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;



}
