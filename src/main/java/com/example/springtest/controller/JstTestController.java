package com.example.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JstTestController {

    @GetMapping
    public String getTestPage(Model model) {
        model.addAttribute("kek", new int[]{1, 2, 3, 4, 5});
        return "jsptest";
    }
}
