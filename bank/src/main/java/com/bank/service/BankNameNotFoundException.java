package com.bank.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT) 
public class BankNameNotFoundException extends Exception {

	public BankNameNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

}
