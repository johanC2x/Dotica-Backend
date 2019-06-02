package com.devswpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping("/")
	public String home() {
		return "Init DoticaApp";
	}

	@GetMapping("/inicio")
	public String index() {
		return "Hello from DoticaApp";
	}
	
}
