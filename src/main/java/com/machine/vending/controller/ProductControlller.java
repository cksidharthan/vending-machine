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

import com.machine.vending.entity.Product;
import com.machine.vending.helper.VendingAppResponse;
import com.machine.vending.service.ProductService;

@RestController
@CrossOrigin
public class ProductControlller {

	private ProductService productService;
	
	@Autowired
	public ProductControlller(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/product")
	public VendingAppResponse<List<Product>> getProducts() {
		List<Product> productList = productService.findAll();
		return new VendingAppResponse<List<Product>>(HttpStatus.OK, "Product Found", productList);
	}
	
	@GetMapping(path="/product/{product_id}")
	public VendingAppResponse<Product> getProductbyId(@PathVariable int product_id) {
		Product productObject;
		try {
			productObject = productService.findById(product_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new VendingAppResponse<Product>(HttpStatus.OK, "Product Found", null);
		}
		return new VendingAppResponse<Product>(HttpStatus.OK, "Product Found", productObject);
	}
	
	@PostMapping(path="/product")
	public VendingAppResponse<String> addProduct(@RequestBody Product productObject) throws Exception {
		productService.save(productObject);
		return new VendingAppResponse<String>(HttpStatus.OK, "Product added", "Product Added Successfully to database");
	}
	
	@DeleteMapping(value="/product/{product_id}")
	public VendingAppResponse<String> deleteProductById(@PathVariable int product_id) {
		try {
			productService.deleteById(product_id);
			return new VendingAppResponse<String>(HttpStatus.OK, "Product deleted", "Product Deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new VendingAppResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
	}
	
}
