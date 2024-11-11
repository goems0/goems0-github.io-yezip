package com.dongduk.yezip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.dongduk.yezip.domain.*;
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
	
	@GetMapping("/address")
	public String showUpdateAddress(@SessionAttribute("uid") int uid, Model model) {
        // 현재 세션에 저장된 uid로 주소 정보를 조회하여 폼에 표시
        Address address = yezip.findAddressByUid(uid);
        // 주소가 null인 경우 기본 빈 객체로 초기화
        if (address == null) {
            address = new Address();
            address.setUid(uid);
        }
        	// 모델에 기존 주소 데이터를 추가하여 폼에 전달
        model.addAttribute("address", address);
        return "update-address"; // 기존 주소를 표시한 폼 페이지로 이동
    }
	
	@PostMapping("/address")
    public String updateAddress(
            @SessionAttribute("uid") int uid,
            @RequestParam("zipcode") String zipcode,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("extra") String extra,
            Model model) {
        
        // 사용자 ID를 통해 Address를 찾아 수정
        Address address = yezip.findAddressByUid(uid);
        if (address != null) {
            address.setZipcode(zipcode);
            address.setCity(city);
            address.setStreet(street);
            address.setExtra(extra);
            
            // 주소 업데이트
            yezip.updateAddress(address);
            
            // 수정된 정보를 모델에 추가하여 화면에 표시
            model.addAttribute("address", address);
            model.addAttribute("message", "주소가 성공적으로 업데이트되었습니다.");
        } else {
            address = new Address(city, street, zipcode, extra, uid);
            // 주소 생성
            yezip.updateAddress(address);
            
            // 수정된 정보를 모델에 추가하여 화면에 표시
            model.addAttribute("address", address);
            model.addAttribute("message", "주소가 성공적으로 업데이트되었습니다.");
        }
        
        return "myPage"; // 주소 수정 후 myPage로 리디렉션
    }
	
}
