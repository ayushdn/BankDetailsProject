package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Bank;
import com.bank.service.BankIdNotFoundException;
import com.bank.service.BankNameNotFoundException;
import com.bank.service.BankService;
import com.bank.service.BankServiceInterface;

@RestController
public class BankController {
	
@Autowired	
private BankServiceInterface bankService;

	@PostMapping("/addBank")
	public Bank addNewBank(@RequestBody Bank bank) {
		
		return bankService.addNewBank(bank);
	}
	
	@GetMapping("/listAllBank")
	public ResponseEntity<List<Bank>> getAllBank(){

		List<Bank> bank = bankService.getAllBank();

		try {

			if (bank.isEmpty()) {
				return ResponseEntity.noContent().build();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(bank);
	}
	
	@GetMapping("/getBankById/{bankId}")
	public ResponseEntity<Bank> getBankById(@Validated @PathVariable(value="bankId")Long bankId) throws BankIdNotFoundException{
		
		Bank bank=bankService.getByBankId(bankId);
		return ResponseEntity.ok().body(bank);
	}
	
	@GetMapping("/getBankByName/{bank_name}")
	public ResponseEntity<Bank> getBankByName(@Validated @PathVariable(value="bank_name")String bank_name) throws BankNameNotFoundException{
		
		Bank bank=bankService.getByBankName(bank_name);
		return ResponseEntity.ok().body(bank);
	}

	
}
