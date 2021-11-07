package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.entity.Bank;


public interface BankDao extends JpaRepository<Bank, Long> {

}
