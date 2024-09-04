package com.springBootTest.Beans;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@GeneratedValue 
	@Id
	private int id;
	
	 @ElementCollection(fetch = FetchType.LAZY)
	 @Column(name = "quantity")
	    private Map<Article, Integer> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Article, Integer> getArticles() {
		return articles;
	}

	public void setArticles(Map<Article, Integer> articles) {
		this.articles = articles;
	}

	public Cart(Map<Article, Integer> articles) {
		super();
		this.articles = articles;
	}

	public Cart() {
		super();
		articles= new HashMap<Article, Integer>();
	}
	
	
	 public float calculPrice() {
		 return (float) articles.entrySet().stream().mapToDouble(e-> e.getKey().getPrice()*e.getValue()).sum();		 
		 
	 }
	 
	 public float calculMasse() {
		 return (float) articles.entrySet().stream().mapToDouble(e-> e.getKey().getMasse()*e.getValue()).sum();
	 }
	
	 public void addArticle(Article a, int quantity) {
		 articles.put(a, quantity);
	 }
	 
	 public void deleteArticle(Article a) {
		 articles.remove(a);
	 }
	 
	 public void modifyQuantity(Article a, int quantity) {
		 articles.replace(a,quantity);
	 }

	@Override
	public String toString() {
		return "Cart [id=" + id + ", articles=" + articles + "]";
	}
	
	
}
