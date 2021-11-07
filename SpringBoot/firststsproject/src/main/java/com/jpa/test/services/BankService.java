package com.jpa.test.services;

import java.util.List;

import com.jpa.test.entity.Bank;


public interface BankService {
	public List<Bank> getBanks(); 
	
	
	public Bank addBank(Bank bank);
	
	
	
	public void deleteBank(long parseLong);
}
