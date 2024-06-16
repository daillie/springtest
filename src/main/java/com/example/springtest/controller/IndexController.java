package com.example.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {

	@GetMapping(value = "/")
	public ModelAndView viewHelloWorld(ModelAndView modelAndView) {				
		modelAndView = new ModelAndView("index");		
		modelAndView.addObject("kek", new int[] {1,2,3,4,5,6});
		return modelAndView;
	
	}
}
