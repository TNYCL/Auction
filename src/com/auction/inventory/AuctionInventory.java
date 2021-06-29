package com.auction.inventory;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class AuctionInventory {
	
	private int auctionid;
	private int price;
	
	public AuctionInventory(int auctionid, int price) {
		this.auctionid = auctionid;
		this.price = price;
	}
	
	public int getAuctionId() {
		return this.auctionid;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static HashMap<Player, AuctionInventory> data = new HashMap<>();
	
	public static AuctionInventory getData(Player player) {
		return data.getOrDefault(player, null);
	}

	public static void addData(Player player, AuctionInventory auctionid) {
		data.put(player, auctionid);
	}
	
	public static void updateData(Player player, AuctionInventory auctionid) {
		data.replace(player, auctionid);
	}
	
	public static void deleteData(Player player) {
		if(getData(player) == null) {
			return;
		}
		data.remove(player);
	}
	
}
