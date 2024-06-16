package com.example.springtest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.exceptions.DuplicateUserNameException;
import com.example.springtest.exceptions.UserNotFoundException;
import com.example.springtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok("User: " + user.getUserName() + " succesfully registered!");
		} catch (DuplicateUserNameException dupe) {
			return ResponseEntity.badRequest().body(dupe.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}

	@GetMapping("/all")
	public ResponseEntity<String> getUsers() {
		try {
			return ResponseEntity.ok(userService.findAll().toString());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(userService.findById(id));
		} catch (UserNotFoundException nfe) {
			return ResponseEntity.badRequest().body(nfe.getMessage());
		} catch (Exception e) {
			System.out.println("CHEEEEEEEE");
			return ResponseEntity.badRequest().body("err");
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Object> deleteEntity(@RequestParam(value = "id") Long id) {
		try {
			return ResponseEntity.ok(userService.deleteById(id));
		} catch (UserNotFoundException nfe) {
			return ResponseEntity.badRequest().body(nfe.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateEntity(@PathVariable("id") Long id, @RequestBody UserEntity newUserInfo){		
		try {
			return ResponseEntity.ok(userService.updateUser(id, newUserInfo));
		} catch (UserNotFoundException nfe) {
			return ResponseEntity.badRequest().body(nfe.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("err");
		}
	}
	
	

}
