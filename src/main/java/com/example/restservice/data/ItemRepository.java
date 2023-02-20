package com.example.restservice.data;

import org.springframework.data.repository.CrudRepository;

import com.example.restservice.models.Item;

// By creating this repository interface without a corresponding controller,
// Spring will automatically create the REST endpoints to go along
// with the specified model.
public interface ItemRepository extends CrudRepository<Item, Long> {}