package com.example.springtest.controller.rest;

import com.example.springtest.exceptions.DuplicateUserEmailException;
import com.example.springtest.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
import com.example.springtest.exceptions.UserNotFoundException;
import com.example.springtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> registerUser(@RequestBody UserEntity user) {
        try {
            System.out.println("REGISTRATION MOMENT");
            userService.registration(user);
            return ResponseEntity.ok(UserModel.toModel(user));
        } catch (DuplicateUserEmailException dupe) {
            System.out.println("unlucky, duplicated email -_-");
            return ResponseEntity.badRequest().body(dupe.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("err");
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Collection<UserEntity>> getUsers() {
        try {
            System.out.println("wqefoiqewfoipwqefijo");
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ArrayList<>());
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
    public ResponseEntity<Object> updateEntity(@PathVariable("id") Long id, @RequestBody UserEntity newUserInfo) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, newUserInfo));
        } catch (UserNotFoundException nfe) {
            return ResponseEntity.badRequest().body(nfe.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("err");
        }
    }

    @GetMapping("/exists")
    public ResponseEntity<Object> existsByEmail(@RequestParam("email") String email) {
        boolean exists = userService.existsByEmail(email);
        if (exists)
            return ResponseEntity.ok(true);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "false");
    }


}
