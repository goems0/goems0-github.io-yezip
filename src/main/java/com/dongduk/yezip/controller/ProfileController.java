package com.dongduk.yezip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String showUpdateProfile(HttpSession session, Model model) {
		// uid에 해당하는 사용자 정보를 가져오는 로직 추가
		int uid = (int) session.getAttribute("uid");
		User user = yezip.findByUid(uid);
		Author author = yezip.findAuthorByUid(uid);
		// 모델에 사용자 정보를 추가
		model.addAttribute("user", user);
		model.addAttribute("author", author);
		return "update-profile";
	}
	
	@PostMapping("/profile-update")
	public String updateProfile(@RequestParam("insta") String insta,
            @RequestParam("intro") String intro,
            @RequestParam("nickname") String nickname,
            @RequestParam("school") String school,
            @RequestParam("career") String career,
//            @RequestParam("file") MultipartFile file,
            HttpSession session,
            Model model) {
		int uid = (int) session.getAttribute("uid");
		User user = yezip.findByUid(uid);
		Author author = yezip.findAuthorByUid(uid);
		
		if (yezip.updateProfile(insta, intro, nickname, school, career, user.getUid()) == 1) {
            model.addAttribute("message", "프로필이 성공적으로 수정되었습니다.");
            author = yezip.findAuthorByUid(uid);
            model.addAttribute("author", author);
        } else {
            model.addAttribute("message", "오류가 발생하였습니다.");
        }
		return "update-profile";
	}
}
