package com.machine.vending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.machine.vending.entity.Transaction;
import com.machine.vending.helper.VendingAppResponse;
import com.machine.vending.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	private TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping("/transaction")
	public VendingAppResponse<List<Transaction>> getTransactions() {
		List<Transaction> transactionList = transactionService.findAll();
		return new VendingAppResponse<List<Transaction>>(HttpStatus.OK, "Transaction Found", transactionList);
	}
	
	@GetMapping(path="/transaction/{transaction_id}")
	public VendingAppResponse<Transaction> getTransactionbyId(@PathVariable int transaction_id) {
		Transaction transactionObject;
		try {
			transactionObject = transactionService.findById(transaction_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new VendingAppResponse<Transaction>(HttpStatus.OK, "Transaction Found", null);
		}
		return new VendingAppResponse<Transaction>(HttpStatus.OK, "Transaction Found", transactionObject);
	}
	
	@PostMapping(path="/transaction")
	public VendingAppResponse<String> addTransaction(@RequestBody Transaction transactionObject) throws Exception {
		String response = transactionService.save(transactionObject);
		return new VendingAppResponse<String>(HttpStatus.OK, response, null);
	}
	
	@PostMapping(path="/transaction/return")
	public VendingAppResponse<String> returnTransaction(@RequestBody Transaction transactionObject) throws Exception {
		String response = transactionService.returnProduct(transactionObject);
		return new VendingAppResponse<String>(HttpStatus.OK, response, null);
	}
	
	@DeleteMapping(value="/transaction/{transaction_id}")
	public VendingAppResponse<String> deleteTransactionById(@PathVariable int transaction_id) {
		try {
			transactionService.deleteById(transaction_id);
			return new VendingAppResponse<String>(HttpStatus.OK, "Transaction deleted", "Transaction Deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new VendingAppResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
	}
	
}
