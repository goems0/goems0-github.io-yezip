package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
	@GetMapping("/profile")
	public String showProfile2() {
		return "profile";
	}
	@GetMapping("/profile/{uid}")
    public String showProfile(@PathVariable String uid, Model model) {
        // uid에 해당하는 사용자 정보를 가져오는 로직 추가
        // 예: User user = userService.findUserByUid(uid);
        
        // 모델에 사용자 정보를 추가
        model.addAttribute("uid", uid);
        // 모델에 사용자 정보를 추가
        // model.addAttribute("user", user);

        // 프로필 페이지 템플릿으로 이동
        return "profile"; // 프로필 페이지의 템플릿 이름
    }
	@GetMapping("/profile-update")
	public String showUpdateProfile() {
		return "update-profile";
	}
}
