package com.met.model;

public class ProductBean {

	private int pid;
	private double price;
	private int stock;
	
	public ProductBean(int pid, double price, int stock) {
		super();
		this.pid = pid;
		this.price = price;
		this.stock = stock;
	}
	
	public int getPid() {
		return pid;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductBean [pid=" + pid + ", price=" + price + ", stock=" + stock + "]";
	}
}
