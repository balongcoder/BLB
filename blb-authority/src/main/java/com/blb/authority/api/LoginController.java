package com.blb.authority.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login/login";
	}
}
