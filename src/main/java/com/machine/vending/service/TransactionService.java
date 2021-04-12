package com.machine.vending.service;

import java.util.List;

import com.machine.vending.entity.Transaction;

public interface TransactionService {
	
	public List<Transaction> findAll();

	public Transaction findById(int transactionId) throws Exception;
	
	public String save(Transaction transactionObject) throws Exception;

	public String returnProduct(Transaction transactionObject) throws Exception;
	
	public void deleteById(int transactionId);

}
