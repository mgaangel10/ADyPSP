package com.example.ejemploJsonViews.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import static com.example.ejemploJsonViews.Model.CustomerView.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
    @JsonView({CustomerList.class, CustomerFull.class})
    private Long id;
    @JsonView({CustomerDetail.class,CustomerFull.class})
    private String nombre;
    @JsonView({CustomerList.class,CustomerEdit.class,CustomerFull.class})
    private String email;
    @JsonView({CustomerDetail.class,CustomerEdit.class,CustomerFull.class})
    private double salario;
    @JsonIgnore
    private String password;
    @JsonView({CustomerEdit.class,CustomerFull.class})
    private String creditCard;
    @JsonView({CustomerDetail.class,CustomerFull.class})
    private LocalDateTime createdAt;
    @JsonView({CustomerDetail.class,CustomerFull.class})
    private LocalDateTime lastlogin;
    @JsonView({CustomerDetail.class,CustomerEdit.class,CustomerFull.class})
    private Integer year;
    @JsonView({CustomerDetail.class,CustomerEdit.class,CustomerFull.class})
    private boolean casado;
}
