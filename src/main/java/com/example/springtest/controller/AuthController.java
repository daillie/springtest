package com.example.springtest.controller;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public String getAuthPage(Model model) {
        for (UserEntity u : userService.findAll()) {
            log.info(u.toString());
        }

        return "auth";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          Model model) {
        log.info("new user request /auth/regitser");
        UserEntity createdUser = userService.registerByRequired(email, password);
        log.info("redirecting to /users/find/" + createdUser.getId());
        return "redirect:/users/find/" + createdUser.getId();
    }

}
