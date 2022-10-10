package com.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("/hello")
	public String homepage() {
		System.out.println("home page");
		return "home";
	}
}
