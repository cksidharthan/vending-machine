package com.machine.vending.service;

import java.util.List;

import com.machine.vending.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findById(int productId) throws Exception;

	public void save(Product productObject);

	public void deleteById(int productId);
	
}
