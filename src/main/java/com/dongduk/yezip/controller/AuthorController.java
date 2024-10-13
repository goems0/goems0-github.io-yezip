package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    @GetMapping("/applicationAuthor")
    public String showApplicationAuthor() {
        return "applicationAuthor";
    }
}
