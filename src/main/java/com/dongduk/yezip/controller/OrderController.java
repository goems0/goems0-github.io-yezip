package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	@GetMapping("/order-list")
	public String showOrderList() {
		return "orderList";
	}
	@GetMapping("/order-detail")
	public String showOrderDetail() {
		return "orderDetail";
	}
}
