package com.example.restservice.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import com.example.restservice.data.CustomerRepository;
import com.example.restservice.models.Customer;

// Creating a controller lets us override the default REST endpoints
// that Spring creates based on the repository.

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    List<Customer> customers = new ArrayList<Customer>();
    customerRepository.findAll().forEach(customers::add);
    return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
  }

  @GetMapping("/customers/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long id) {
    Optional<Customer> customer = customerRepository.findById(id);
    if (customer.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
  }

  @PostMapping("/customers")
  public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.CREATED);
  }

  @DeleteMapping("/customers/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") long id) {
    customerRepository.deleteById(id);
    return new ResponseEntity<String>("Customer deleted.", HttpStatus.OK);
  }
}