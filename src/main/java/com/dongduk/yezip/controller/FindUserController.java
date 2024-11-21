package com.dongduk.yezip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongduk.yezip.domain.User;
import com.dongduk.yezip.service.YezipFacade;

import jakarta.servlet.http.HttpSession;


@Controller
public class FindUserController {
	private YezipFacade yezip;
	@Autowired
	public void setYezip(YezipFacade yezip) {
		this.yezip = yezip;
	}
	
    @GetMapping("/findId")
    public String showFindId() {
        return "findId";
    }
    
    @PostMapping("/findId")
    @ResponseBody
    public Map<String, Object> findId(@RequestParam String name, @RequestParam String phone, Model model) {
    	 Map<String, Object> response = new HashMap<>();
    	 
        // 데이터베이스에서 이름과 전화번호로 아이디 조회
        User user = yezip.findByNameAndPhone(name, phone);

        if (user != null) {
        	response.put("success", true);
            response.put("userId", user.getUserid()); // 성공 시 user를 전달
        } else {
        	response.put("success", false);
            response.put("message", "입력하신 정보와 일치하는 아이디가 없습니다."); // 실패 메시지 전달
        }

        return response;
    }
    
    @GetMapping("/findPw")
    public String showFindPw() {
        return "findPw";
    }
    
 // 비밀번호 찾기 (유저 정보 확인)
    @PostMapping("/findPw")
    @ResponseBody
    public Map<String, Object> findPassword(String id, String name, String phone, HttpSession session) {
    	Map<String, Object> response = new HashMap<>();
        User user = yezip.findByUseridAndNameAndPhone(id, name, phone); // 사용자 정보 확인
        
        if (user != null) {
        	String password = user.getPw();
        	int length = password.length();
            int halfLength = length / 2;
            String visiblePart = password.substring(0, halfLength); // 앞 절반
            String maskedPart = "*".repeat(length - halfLength);    // 뒤 절반
        	response.put("success", true);
            response.put("pw", visiblePart + maskedPart);
            session.setAttribute("uid", user.getUid());
        } else {
        	response.put("success", false);
            response.put("message", "일치하는 사용자 정보를 찾을 수 없습니다."); // 실패 메시지 전달
        }

        return response; 
    }
    
    @GetMapping("/resetPw")
    public String showResetPw() {
        return "resetPw";
    }
    
    @PostMapping("/resetPw")
    @ResponseBody
    public Map<String, Object> resetPw(
            @RequestParam("newPw") String pw,
            @RequestParam("confirmPw") String confirmPw,
            HttpSession session) {
    	Map<String, Object> response = new HashMap<>();
    	if (!pw.equals(confirmPw)) {
    		response.put("success", false);
    		response.put("message", "비밀번호가 일치하지 않습니다.");
    		return response;
    	}
    	int uid = (int) session.getAttribute("uid");
    	if (yezip.updatePw(pw, uid) == 1) {
    		response.put("success", true);
    	} else {
    		response.put("success", false);
    		response.put("message", "오류가 발생하였습니다.");
    		return response;
    	}
        return response; 
    }
}
