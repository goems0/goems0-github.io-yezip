package com.dongduk.yezip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

@Controller
public class AuthorController {
    @GetMapping("/applicationAuthor")
    public String showApplicationAuthor() {
        return "applicationAuthor";
    }
    @PostMapping("/applicationAuthor")
    @ResponseBody
    public Map<String, String> handleApplication(
            @RequestParam("insta") String insta,
            @RequestParam("intro") String intro,
            @RequestParam("name") String name,
            @RequestParam("nickname") String nickname,
            @RequestParam("birth") String birth,
            @RequestParam("school") String school,
            @RequestParam("career") String career,
            @RequestParam("file") MultipartFile file) {
        
        // 파일 처리 로직

        // 응답 메시지 생성
        Map<String, String> response = new HashMap<>();
        response.put("message", "신청이 성공적으로 제출되었습니다.");
        
        return response;
    }


}
