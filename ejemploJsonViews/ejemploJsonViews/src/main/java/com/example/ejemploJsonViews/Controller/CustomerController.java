package com.example.ejemploJsonViews.Controller;

import com.example.ejemploJsonViews.Model.Customer;
import com.example.ejemploJsonViews.Model.CustomerView;
import com.example.ejemploJsonViews.Repo.CustomerRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.ejemploJsonViews.Model.CustomerView.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private List<Customer> customers;
    private CustomerRepo customerRepo;
    public CustomerController() {
        this.customers = List.of(
                new Customer(1L,"cust1","cust1@gmail.com",1300,"admin","1234", LocalDateTime.now(),LocalDateTime.now(),2021,true),
                new Customer(2L,"cust2","cust2@gmail.com",1300,"admin","1234", LocalDateTime.now(),LocalDateTime.now(),2021,true),
                new Customer(3L,"cust3","cust3@gmail.com",1300,"admin","1234", LocalDateTime.now(),LocalDateTime.now(),2021,true)

        );
    }
@GetMapping("/")
@JsonView(CustomerDetail.class)
    public List<Customer> findall() {
        return customers;
    }
    @GetMapping("/{id}")
    @JsonView(CustomerDetail.class)
    public Customer findaById(@PathVariable Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }
    @GetMapping("/edit/{id}")
    @JsonView(CustomerEdit.class)
    public Customer findaByIdForEdit(@PathVariable Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }
}
