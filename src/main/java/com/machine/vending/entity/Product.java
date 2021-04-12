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
@Table(name="PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="CREATED_TIME")
	private Date createdTime;
	
	@Column(name="UPDATED_TIME")
	private Date updatedTime;
	
	@Column(name="REMAINING_QTY")
	private int remainingQty;
	
	@Column(name="SOLD_QTY")
	private int soldQty;
	
	public Product() {
		super();
	}
	
	public Product(String name, String description, int price, Time createdTime, Time updatedTime, int remainingQty,
			int soldQty) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.remainingQty = remainingQty;
		this.soldQty = soldQty;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}

	public int getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(int soldQty) {
		this.soldQty = soldQty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", remainingQty=" + remainingQty
				+ ", soldQty=" + soldQty + "]";
	}
	
}
