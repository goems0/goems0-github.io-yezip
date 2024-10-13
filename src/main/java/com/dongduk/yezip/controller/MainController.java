package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/main"})
    public String main() {
        return "main"; 
    }
    @GetMapping("/whole-items")
    public String showWholeItems() {
        return "whole-items"; 
    }
}
