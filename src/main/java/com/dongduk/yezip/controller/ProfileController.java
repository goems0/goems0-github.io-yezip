package com.dongduk.yezip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dongduk.yezip.domain.*;
import com.dongduk.yezip.service.YezipFacade;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {
	private final YezipFacade yezip;

    @Autowired
    public ProfileController(YezipFacade yezip) {
        this.yezip = yezip;
    }
    
	// 본인 작가 프로필 조회
	@GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        // uid에 해당하는 사용자 정보를 가져오는 로직 추가
		int uid = (int) session.getAttribute("uid");
        User user = yezip.findByUid(uid);
        Author author = yezip.findAuthorByUid(uid);
        // 모델에 사용자 정보를 추가
         model.addAttribute("user", user);
         model.addAttribute("author", author);
        // 프로필 페이지 템플릿으로 이동
        return "profile"; // 프로필 페이지의 템플릿 이름
    }
	
	@GetMapping("/profile-update")
	public String showUpdateProfile() {
		return "update-profile";
	}
}
