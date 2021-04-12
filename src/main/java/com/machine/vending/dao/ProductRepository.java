package com.machine.vending.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machine.vending.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
