package com.springBootTest.Beans;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", firstName=" + firstName + ", ddn=" + ddn + "]";
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String firstName, Date ddn) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.ddn = ddn;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	@Column
	private String name;
	
	@Column
	private String firstName;
	
	@Column
	private Date ddn;
	
	

}
