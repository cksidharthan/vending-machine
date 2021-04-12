package com.machine.vending.service;

import java.util.List;

import com.machine.vending.entity.AdminOperation;

public interface AdminOperationsService {

	public List<AdminOperation> findAll();

	public AdminOperation findById(int adminOperationId) throws Exception;

	public String runOperation(AdminOperation adminOperationObject);

	public void deleteById(int adminOperationId);
	
}
