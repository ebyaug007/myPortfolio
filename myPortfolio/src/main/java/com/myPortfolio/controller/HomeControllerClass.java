package com.myPortfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerClass {
	
	@RequestMapping("/")
	public String homepage()
	{
		return "index";
	}
	
}
