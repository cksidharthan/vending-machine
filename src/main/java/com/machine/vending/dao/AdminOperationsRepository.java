package com.machine.vending.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machine.vending.entity.AdminOperation;

public interface AdminOperationsRepository extends JpaRepository<AdminOperation, Integer> {

}
