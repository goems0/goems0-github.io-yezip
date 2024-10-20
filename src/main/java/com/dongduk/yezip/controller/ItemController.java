package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	@GetMapping("/item/register")
	public String showRegisterItem() {
		return "register-item";
	}
}
