package com.machine.vending.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="MONEY_IN")
	private float moneyIn;
	
	@Column(name="MONEY_OUT")
	private float moneyOut;
	
	@Column(name="OPERATION_TIME")
	private Date operationTime;
	
	@Column(name="VENDING_STATUS")
	private boolean vendingStatus;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int productId, int quantity, float moneyIn, float moneyOut, Time operationTime, boolean vendingStatus) {
		super();
		this.productId = productId;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
		this.operationTime = operationTime;
		this.vendingStatus = vendingStatus;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getMoneyIn() {
		return moneyIn;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setMoneyIn(float moneyIn) {
		this.moneyIn = moneyIn;
	}

	public float getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(float moneyOut) {
		this.moneyOut = moneyOut;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public boolean isVendingStatus() {
		return vendingStatus;
	}

	public void setVendingStatus(boolean vendingStatus) {
		this.vendingStatus = vendingStatus;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", productId=" + productId + ", quantity=\" + quantity + \", moneyIn=" + moneyIn + ", moneyOut=" + moneyOut
				+ ", operationTime=" + operationTime + ", vendingStatus=" + vendingStatus + "]";
	}
	
}
