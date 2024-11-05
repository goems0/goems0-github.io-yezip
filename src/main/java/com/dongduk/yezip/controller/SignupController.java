package com.dongduk.yezip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.yezip.domain.User;
import com.dongduk.yezip.service.YezipFacade;


@Controller
public class SignupController {
	private YezipFacade yezip;
	@Autowired
	public void setYezip(YezipFacade yezip) {
		this.yezip = yezip;
	}
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }
    // 회원가입
    @PostMapping("/signup")
    public String signup(@RequestParam("id") String id,
                         @RequestParam("pw") String pw,
                         @RequestParam("confirmPw") String confirmPw,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("email") String email,
                         // 약관 동의 2개
                         @RequestParam(value = "yakgwan-check", defaultValue = "false") boolean check1,
                         @RequestParam(value = "info-check", defaultValue = "false") boolean check2,
                         Model model) {
    	// 비밀번호 확인, 약관 2개 체크되어있는지 확인
    	if (pw.equals(confirmPw)) {
    		User user = new User(id, pw, name, phone, email);
    		if (check1 & check2) {
    			// 사용자 저장
    			if (yezip.registerUser(user)) {
    				return "redirect:main"; // 회원가입 성공 시 메인
    			} else {
    				model.addAttribute("error", "회원가입에 실패했습니다. 다시 시도해주세요.");
    			}
    		}

    	} else {
    		model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
    	}
        
        return "signup"; // 실패 시 다시 회원가입 페이지로 돌아감
    }
}
