package com.example.PayMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.PayMe.model.Virement;
import com.example.PayMe.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactionsPage(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("transactions", transactionService.getTransactionsListByUserName(userName));
		return "transactionsPage";
	}
}
