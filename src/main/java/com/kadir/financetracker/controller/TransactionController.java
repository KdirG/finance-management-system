package com.kadir.financetracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List

@RestController
@RequestMapping("/api/transactions")
public class TransactionController{
			 @Autowired
private final TransactionService transactionservice;


	
	

