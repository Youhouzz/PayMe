package com.example.PayMe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PayMe.model.Transaction;
import com.example.PayMe.model.User;
import com.example.PayMe.repository.TransactionRepository;
import com.example.PayMe.repository.UserRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Transaction> getTransactionsListByUserName(String userName) {
		User user = userRepository.getUserByName(userName);
		return transactionRepository.findAllBySender(user);
	}

}
