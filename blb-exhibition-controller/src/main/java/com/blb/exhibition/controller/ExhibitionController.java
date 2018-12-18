package com.blb.exhibition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExhibitionController {

	@RequestMapping("/index")
	public String index() {
		return "exhibition/index";
	}
}
