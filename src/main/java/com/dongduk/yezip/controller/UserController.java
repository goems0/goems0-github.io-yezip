package com.dongduk.yezip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String showUserInfo(HttpSession session, Model model) {
		int uid = (int) session.getAttribute("uid");
		User user = yezip.findByUid(uid);
		model.addAttribute("user", user);
		
		// 유효한 도메인 목록
		String[] validDomains = {"naver.com", "gmail.com", "hanmail.net", "daum.net", "kakao.com", "outlook.com"};
		
		// 이메일 분리 후 model에 추가
	    String[] emailParts = user.getEmail().split("@", 2);
	    
	 // 유효한 도메인 목록에 포함되지 않으면 'input'으로 설정
	    boolean isValidDomain = false;
	    for (String validDomain : validDomains) {
	        if (emailParts[1].equals(validDomain)) {
	            isValidDomain = true;
	            break;
	        }
	    }
	    
	    // 도메인이 유효하지 않으면 'input' 처리
	    if (!isValidDomain) {
	    	model.addAttribute("email1", user.getEmail());
	    	model.addAttribute("email2", "input");
	    }
	    else {
	    	model.addAttribute("email1", emailParts[0]);
	    	model.addAttribute("email2", "@" + emailParts[1]);
	    }
		return "userInfo";
	}
	
	@PostMapping("/userInfo")
	@ResponseBody // JSON 형식 응답을 위해 추가
	public Map<String, Object> updateUserInfo(@RequestParam("id") String id,
                                     @RequestParam("pw") String pw,
                                     @RequestParam("confirmPw") String confirmPw,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("email") String email,
                                     @RequestParam("email2") String email2,
                                     Model model, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		
		//회원 찾기
		int uid = (int) session.getAttribute("uid");
		User user = yezip.findByUid(uid);
		// 회원정보 수정
        if (!pw.equals(confirmPw)) {
            result.put("success", false);
            result.put("error", "비밀번호가 일치하지 않습니다.");
            return result;
        }

     // 본인 아이디를 제외한 중복 체크
        if (!id.equals(user.getUserid()) && yezip.isIdDuplicate(id)) {
            result.put("success", false);
            result.put("error", "이미 사용 중인 아이디입니다. 다시 시도해주세요.");
            return result;
        }

        if (!email2.equals("input")) {
            email = email + email2;
        }
        
		if (yezip.updateUser(id, pw, name, phone, email, uid) == 1){
			user = yezip.findByUid(uid);
			model.addAttribute("user", user);
			session.setAttribute("username", user.getName());
			session.setAttribute("uid", user.getUid());
			// 이메일 분리 후 model에 추가
		    String[] emailParts = user.getEmail().split("@", 2);
		    model.addAttribute("email1", emailParts[0]);
		    model.addAttribute("email2", "@" + emailParts[1]);
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("error", "회원정보 수정에 실패하였습니다.");
            return result;
        }
		return result;
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
	
	// 회원 탈퇴 처리
	@PostMapping("/deleteUser")
	public ResponseEntity<Map<String, Object>> deleteUser(HttpSession session) {
	    int uid = (int) session.getAttribute("uid");
	    User user = yezip.findByUid(uid);  // 세션에서 유저 정보 조회
	    
	    // 탈퇴 처리
	    boolean success = yezip.deleteUser(user);
	    session.invalidate();
	    // 응답 메시지
	    Map<String, Object> response = new HashMap<>();
	    if (success) {
	        response.put("success", true);
	    } else {
	        response.put("success", false);
	    }

	    return ResponseEntity.ok(response);
	}

	
}
