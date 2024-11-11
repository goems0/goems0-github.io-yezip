package com.dongduk.yezip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.yezip.domain.Item;
import com.dongduk.yezip.service.YezipFacade;

@Controller
public class SearchController {
private final YezipFacade yezip;
	
	@Autowired
    public SearchController(YezipFacade yezip) {
        this.yezip = yezip;
    }
	
    @GetMapping("/search")
    public String showSearch() {
        return "search-result";
    }
    
    @PostMapping("/search")
    public String handleSearch(
            @RequestParam("keyword") String keyword,
            Model model) {
    	List<Item> itemList = yezip.findByTitle(keyword);
    	model.addAttribute("itemList", itemList);
    	model.addAttribute("keyword", keyword);
        // 처리 후에 적절한 뷰로 리다이렉트 또는 포워드합니다.
        return "search-result"; // 예시: 성공 페이지로 리다이렉트
    }
}
