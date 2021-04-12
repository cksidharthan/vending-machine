package com.machine.vending.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_OPERATION")
public class AdminOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="OPERATION_TIME")
	private int operationTime;
	
	public AdminOperation() {
		super();
	}
	
	public AdminOperation(String name, String code, int operationTime) {
		super();
		this.name = name;
		this.code = code;
		this.operationTime = operationTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(int operationTime) {
		this.operationTime = operationTime;
	}

	@Override
	public String toString() {
		return "AdminOperation [id=" + id + ", name=" + name + ", code=" + code + ", operationTime=" + operationTime
				+ "]";
	}
	
}