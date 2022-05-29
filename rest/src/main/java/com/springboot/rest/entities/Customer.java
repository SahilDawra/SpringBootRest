package com.springboot.rest.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {
	String customerName;
	String country;
	@Id
	long ID;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, String country, long iD) {
		super();
		this.customerName = customerName;
		this.country = country;
		ID = iD;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", country=" + country + ", ID=" + ID + "]";
	}

}
