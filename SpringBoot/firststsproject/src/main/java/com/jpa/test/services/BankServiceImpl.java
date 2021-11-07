package com.jpa.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.BankDao;
import com.jpa.test.entity.Bank;


@Service
public class BankServiceImpl implements BankService {

	
	@Autowired
	private BankDao bankDao;
	
	
	
	public BankServiceImpl() {
		
	}

	@Override
	public List<Bank> getBanks() {
		
		return bankDao.findAll();
	}

	@Override
	public Bank addBank(Bank bank) {
		bankDao.save(bank);
		return bank;
	}

	@Override
	public void deleteBank(long parseLong) {
		Bank entity=bankDao.getById(parseLong);
		bankDao.delete(entity);

	}

}
