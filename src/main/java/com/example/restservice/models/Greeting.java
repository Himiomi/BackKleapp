package com.example.restservice.models;

import lombok.Getter;
import lombok.Setter;

public class Greeting {

  @Getter
	private final long id;

  @Getter
  @Setter
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

}
