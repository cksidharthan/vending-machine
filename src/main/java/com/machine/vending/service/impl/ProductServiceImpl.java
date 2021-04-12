package com.machine.vending.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.machine.vending.dao.ProductRepository;
import com.machine.vending.entity.Product;
import com.machine.vending.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public Product findById(int productId) throws Exception {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Product productObject = null;
		if (optionalProduct.isPresent()) {
			productObject = optionalProduct.get();
		} else {
			throw new Exception("Did not find Product with id - " + productId);
		}
		return productObject;
	}

	@Override
	public void save(Product productObject) {
		productRepository.save(productObject);
	}

	@Override
	public void deleteById(int productId) {
		productRepository.deleteById(productId);
	}

}
