package com.example.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/post")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
		try {
			userRepo.save(user);
			return ResponseEntity.ok("Пользователь был успешно сохранён");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}

	@GetMapping("/get")
	public ResponseEntity<String> getUsers() {
		try {

			return ResponseEntity.ok("бебра");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}
}
