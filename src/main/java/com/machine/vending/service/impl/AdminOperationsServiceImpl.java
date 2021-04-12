package com.machine.vending.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.machine.vending.dao.AdminOperationsRepository;
import com.machine.vending.dao.ProductRepository;
import com.machine.vending.dao.TransactionRepository;
import com.machine.vending.entity.AdminOperation;
import com.machine.vending.service.AdminOperationsService;


@Service
public class AdminOperationsServiceImpl implements AdminOperationsService {

	private AdminOperationsRepository adminOperationsRepository;
	private TransactionRepository transactionRepository;
	private ProductRepository productRepository;
	
	public AdminOperationsServiceImpl(AdminOperationsRepository adminOperationsRepository, TransactionRepository transactionRepository, ProductRepository productRepository) {
		this.adminOperationsRepository = adminOperationsRepository;
		this.transactionRepository = transactionRepository;
		this.productRepository = productRepository;
	}
	
	@Transactional
	public List<AdminOperation> findAll() {
		return adminOperationsRepository.findAll();
	}

	@Transactional
	public AdminOperation findById(int adminOperationId) throws Exception {
		Optional<AdminOperation> optionaladminOperation = adminOperationsRepository.findById(adminOperationId);
		AdminOperation adminOperationObject = null;
		if (optionaladminOperation.isPresent()) {
			adminOperationObject = optionaladminOperation.get();
		} else {
			throw new Exception("Did not find Admin Operation with id - " + adminOperationId);
		}
		return adminOperationObject;
	}

	@Transactional
	public String runOperation(AdminOperation adminOperationObject) {
		if (adminOperationObject.getCode() == "RESET") {
			productRepository.deleteAllInBatch();
			transactionRepository.deleteAllInBatch();
		}
		adminOperationsRepository.save(adminOperationObject);
		return adminOperationObject.getCode() + " operation completed successfully";
	}

	@Transactional
	public void deleteById(int adminOperationId) {
		adminOperationsRepository.deleteById(adminOperationId);
	}

}
