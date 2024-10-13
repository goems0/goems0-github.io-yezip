package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String showSearch() {
        return "search-result";
    }
    @PostMapping("/search")
    public String handleSearch(
            @RequestParam("keyword") String keyword) {

        // 처리 후에 적절한 뷰로 리다이렉트 또는 포워드합니다.
        return "search-result"; // 예시: 성공 페이지로 리다이렉트
    }
}
