package com.dongduk.yezip.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dongduk.yezip.domain.*;
import com.dongduk.yezip.service.YezipFacade;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class AuthorController {
	private final YezipFacade yezip;
	
	@Autowired
    public AuthorController(YezipFacade yezip) {
        this.yezip = yezip;
    }
	
    @GetMapping("/applicationAuthor")
    public String showApplicationAuthor() {
        return "applicationAuthor";
    }
    
    @PostMapping("/applicationAuthor")
    public String handleApplication(
            @RequestParam("insta") String insta,
            @RequestParam("intro") String intro,
            @RequestParam("nickname") String nickname,
            @RequestParam("school") String school,
            @RequestParam("career") String career,
            @RequestParam("file") MultipartFile file,
            HttpSession session,
            Model model) {
        
        String userid = (String) session.getAttribute("userid");
        
        if (userid == null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "applicationAuthor"; // 로그인 필요 메시지와 함께 현재 페이지로 돌아감
        }

        User user = yezip.findByUserid(userid);
        Author author = new Author(insta, intro, nickname, school, career, user.getUid());
        
        if (yezip.registerAuthor(author)) {
            model.addAttribute("message", "신청이 성공적으로 제출되었습니다.");
            model.addAttribute("author", author);
        } else {
            model.addAttribute("message", "오류가 발생하였습니다.");
        }
        
        return "profile"; // 프로필 페이지로 이동
    }




}
