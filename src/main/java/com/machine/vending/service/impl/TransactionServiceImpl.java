package com.machine.vending.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.machine.vending.dao.ProductRepository;
import com.machine.vending.dao.TransactionRepository;
import com.machine.vending.entity.Product;
import com.machine.vending.entity.Transaction;
import com.machine.vending.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository transactionRepository;
	private ProductRepository productRepository;

	public TransactionServiceImpl(TransactionRepository transactionRepository, ProductRepository productRepository) {
		this.transactionRepository = transactionRepository;
		this.productRepository = productRepository;
	}

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction findById(int transactionId) throws Exception {
		Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
		Transaction transactionObject = null;
		if (optionalTransaction.isPresent()) {
			transactionObject = optionalTransaction.get();
		} else {
			throw new Exception("Did not find Transaction with id - " + transactionId);
		}
		return transactionObject;
	}

	@Override
	public String save(Transaction transactionObject) throws Exception {
		Optional<Product> optionalProduct = productRepository.findById(transactionObject.getProductId());
		Product productObject = null;
		if (optionalProduct.isPresent()) {
			productObject = optionalProduct.get();
		} else {
			return ("Did not find Product with id - " + transactionObject.getProductId());
		}
		if (productObject.getRemainingQty() < transactionObject.getQuantity()) {
			return ("Ordered quantity of products not in stock. Please Enter quantity below " + productObject.getRemainingQty());
		}
		float transactionCost = productObject.getPrice() * transactionObject.getQuantity();
		float remainingAmount = 0;
		if (transactionObject.getMoneyIn() < transactionCost) {
			return "Insufficient money. Need " + (transactionCost - transactionObject.getMoneyIn()) + " more";
		} else if (transactionObject.getMoneyIn() >= transactionCost) {
			// update transaction table
			remainingAmount = transactionObject.getMoneyIn() - transactionCost;
			transactionObject.setMoneyOut(remainingAmount);
			transactionObject.setOperationTime(new Date());
			transactionObject.setVendingStatus(true);
			
			// update product table
			productObject.setRemainingQty(productObject.getRemainingQty() - transactionObject.getQuantity());
			productObject.setSoldQty(productObject.getSoldQty() +  transactionObject.getQuantity());
			productObject.setUpdatedTime(new Date());
			
			productRepository.save(productObject);
			transactionRepository.save(transactionObject);
		}
		return "Transaction added Successfully. Remaining Change: " + remainingAmount;
	}

	@Override
	public void deleteById(int transactionId) {
		transactionRepository.deleteById(transactionId);
	}

	@Override
	public String returnProduct(Transaction transactionObject) throws Exception {
		Optional<Product> optionalProduct = productRepository.findById(transactionObject.getProductId());
		Product productObject = null;
		if (optionalProduct.isPresent()) {
			productObject = optionalProduct.get();
		} else {
			return ("Did not find Product with id - " + transactionObject.getProductId());
		}
		
		// Making changes to product to reflect the refund 
		float returnValue = transactionObject.getQuantity() * productObject.getPrice();
		productObject.setRemainingQty(productObject.getRemainingQty() + transactionObject.getQuantity());
		productObject.setSoldQty(productObject.getSoldQty() - transactionObject.getQuantity());
		productRepository.save(productObject);
		
		// making changes to the transaction object to reflect the money in and money out
		transactionObject.setMoneyIn(0);
		transactionObject.setMoneyOut(returnValue);
		transactionObject.setOperationTime(new Date());
		transactionObject.setVendingStatus(false);
		transactionRepository.save(transactionObject);
		
		return "Refund Amount: " + returnValue;
	}

}
