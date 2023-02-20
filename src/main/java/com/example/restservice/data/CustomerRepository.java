package com.example.restservice.data;

import org.springframework.data.repository.CrudRepository;
import com.example.restservice.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}