package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/myPage")
	public String showMyPage() {
		return "myPage";
	}
	@GetMapping("/userInfo")
	public String showUserInfo() {
		return "userInfo";
	}
}
