package com.example.dairyfarm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private int quantity;
    private double total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", product=" + product + ", quantity=" + quantity + ", total=" + total + "]";
	}
	public Invoice(Long id, String product, int quantity, double total) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}
	public Invoice() {
		super();
	}

    
    // getters and setters
}
