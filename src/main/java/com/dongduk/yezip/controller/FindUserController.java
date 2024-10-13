package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindUserController {
    @GetMapping("/findId")
    public String showFindId() {
        return "findId";
    }
    @GetMapping("/findPw")
    public String showFindPw() {
        return "findPw";
    }
    @GetMapping("/resetPw")
    public String showResetPw() {
        return "resetPw";
    }
    @PostMapping("/resetPw")
    public String handleResetPw(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone) {
        // 여기에서 비밀번호 재설정 로직을 처리합니다.
        // 예: 유효성 검사, 비밀번호 재설정 처리, 이메일 발송 등

        // 처리 후에 적절한 뷰로 리다이렉트 또는 포워드합니다.
        return "resetPw"; // 예시: 성공 페이지로 리다이렉트
    }
}
