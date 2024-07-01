package com.example.PayMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String getHome(Model model) {
		return ("home");
	}
	
	
	@GetMapping("/testLog")
	public String getTestLog(Model model) {
		return ("home");
	}

}
