package com.bank.service;

import java.util.List;

import com.bank.model.Bank;

public interface BankServiceInterface  {

	public Bank addNewBank(Bank bank) ;
	
	public List<Bank> getAllBank();
	
	public Bank getByBankId(Long bankId) throws BankIdNotFoundException;
	
	public Bank getByBankName(String bank_name) throws BankNameNotFoundException;
}
