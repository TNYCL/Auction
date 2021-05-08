package com.craftrise.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.craftrise.data.Status;

public class Auction {

	public Status status;
	public int auctionid;
	public int time;
	public Map<String, Object> itemdata = new HashMap<>();
	public List<Bidder> lastbidder = new ArrayList<>();
	public String owner;
	public int price;

	public Auction(String owner, int auctionid, int price) {
		this.status = Status.STARTED;
		this.owner = owner;
		this.auctionid = auctionid;
		this.time = 600;
		this.price = price;
	}

	public List<Bidder> getBidder() {
		return this.lastbidder;
	}
	
	public Bidder getLastBidder() {
		return this.lastbidder.get(this.lastbidder.size() -1);
	}

	public String getOwner() {
		return this.owner;
	}

	public int getAuctionId() {
		return this.auctionid;
	}

	public int getTime() {
		return this.time;
	}

	public Map<String, Object> getItemData() {
		return itemdata;
	}

	public int getPrice() {
		return this.price;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void addLastBidder(Bidder bidder) {
		this.lastbidder.add(bidder);
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void setItemData(Map<String, Object> data) {
		this.itemdata = data;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

}
