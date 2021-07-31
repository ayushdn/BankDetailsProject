package com.bank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	
	public Optional<Bank> findByBankName(String bank_name);

}
