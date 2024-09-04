package com.springBootTest.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
	
	@GeneratedValue
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int stock;
	
	@Column
	private float masse;
	
	@Column 
	private float price;

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getMasse() {
		return masse;
	}

	public void setMasse(float masse) {
		this.masse = masse;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", stock=" + stock + ", masse=" + masse + ", price=" + price
				+ "]";
	}

	public Article(String name, int stock, float masse, float price) {
		super();
		this.name = name;
		this.stock = stock;
		this.masse = masse;
		this.price = price;
	}

	public Article() {
		super();
	}
	
	
	

}
