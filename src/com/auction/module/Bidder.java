package com.auction.module;

public class Bidder {
	
	private String name;
	private int price;
	private String time;
	
	public Bidder(String name, int price, String time) {
		this.name = name;
		this.price = price;
		this.time = time;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

}
