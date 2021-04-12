package com.machine.vending.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machine.vending.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
