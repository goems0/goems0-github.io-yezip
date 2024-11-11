package com.dongduk.yezip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dongduk.yezip.domain.Author;
import com.dongduk.yezip.domain.User;
import com.dongduk.yezip.service.YezipFacade;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	private final YezipFacade yezip;

    @Autowired
    public UserController(YezipFacade yezip) {
        this.yezip = yezip;
    }
    
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		// uid에 해당하는 사용자 정보를 가져오는 로직 추가
		String userid = (String) session.getAttribute("userid");
		int uid = (int) session.getAttribute("uid");
        User user = yezip.findByUserid(userid);
        Author author = yezip.findAuthorByUid(user.getUid());
        // 모델에 사용자 정보를 추가
         model.addAttribute("user", user);
         model.addAttribute("author", author);
         session.setAttribute("uid", uid);
		return "myPage";
	}
	
	@GetMapping("/userInfo")
	public String showUserInfo() {
		return "userInfo";
	}
}
