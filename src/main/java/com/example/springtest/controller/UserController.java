package com.example.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@GetMapping("/get")
	public ResponseEntity<String> getUsers() {
		try {

			return ResponseEntity.ok("working");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}
}
