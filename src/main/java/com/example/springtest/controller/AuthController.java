package com.example.springtest.controller;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getAuthPage(Model model) {
        return "auth";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          Model model) {
        UserEntity createdUser = userService.registerByRequired(email, password);
        System.out.println("ауауауааууауа");
        return "redirect:/users/find/" + createdUser.getId();
    }

}
