package com.example.restservice.controllers;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.example.restservice.models.Greeting;
import com.example.restservice.models.Person;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/")
  public String defaultMessage() {
    return "Bienvenu sur le back end de Kleapp :)";
  }

  @GetMapping("/greeting")
  public ResponseEntity<Greeting> getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new ResponseEntity<Greeting>(new Greeting(counter.incrementAndGet(), String.format(template, name)),HttpStatus.OK);
  }

  @PostMapping("/greeting")
  public ResponseEntity<Greeting> postGreeting(@RequestBody Person person) {
    return new ResponseEntity<Greeting>(new Greeting(counter.getAndIncrement(), String.format(template, person.getName())), HttpStatus.OK);
  }
}
