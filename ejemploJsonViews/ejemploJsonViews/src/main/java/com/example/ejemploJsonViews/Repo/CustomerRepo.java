package com.example.ejemploJsonViews.Repo;

import com.example.ejemploJsonViews.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
