package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.BankRepository;
import com.bank.model.Bank;

@Service
public class BankService implements BankServiceInterface{

	@Autowired
	private BankRepository bankRepository;
	
	public Bank addNewBank(Bank bank) {

		return bankRepository.save(bank);
	}

	public List<Bank> getAllBank() {

		return bankRepository.findAll();
	}

	public Bank getByBankId(Long bankId) throws BankIdNotFoundException {

		Optional<Bank> bank = bankRepository.findById(bankId);
		return bank.stream().filter(c -> c.getBankId().equals(bankId)).findAny()
				.orElseThrow(() -> new BankIdNotFoundException("Bank ID not found"));

	}

	public Bank getByBankName(String bank_name) throws BankNameNotFoundException {

		Optional<Bank> bank = bankRepository.findByBankName(bank_name);
		return bank.stream().filter(c -> c.getBankName().equalsIgnoreCase(bank_name) && c.getBankName().startsWith("S"))
				.findAny().orElseThrow(() -> new BankNameNotFoundException("Bank Name Not found"));

	}
	
}
