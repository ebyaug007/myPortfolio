package com.springsec.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlPageMapping {
	
	@GetMapping("login")
	public String getLoginPage()
	{
		return "login";
	}
	@GetMapping("firstpage")
	public String getFirstPage()
	{
		return "frontpage";
	}

}
