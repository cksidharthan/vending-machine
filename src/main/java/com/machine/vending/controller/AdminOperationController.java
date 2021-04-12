package com.machine.vending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.machine.vending.entity.AdminOperation;
import com.machine.vending.helper.VendingAppResponse;
import com.machine.vending.service.AdminOperationsService;

@RestController
@CrossOrigin
public class AdminOperationController {

	private AdminOperationsService adminOperationsService;
	
	@Autowired
	public AdminOperationController(AdminOperationsService adminOperationsService) {
		this.adminOperationsService = adminOperationsService;
	}
	
	@GetMapping("/adminOperations")
	public VendingAppResponse<List<AdminOperation>> getAdminOperations() {
		List<AdminOperation> adminOperations = adminOperationsService.findAll();
		return new VendingAppResponse<List<AdminOperation>>(HttpStatus.OK, "AdminOperation Found", adminOperations);
	}
	
	@PostMapping(path="/adminOperation")
	public VendingAppResponse<String> addProduct(@RequestBody AdminOperation adminOperationObject) throws Exception {
		String response = adminOperationsService.runOperation(adminOperationObject);
		return new VendingAppResponse<String>(HttpStatus.OK, response, null);
	}
	
}
