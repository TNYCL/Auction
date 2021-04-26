package com.craftrise.cache;

import java.util.TreeMap;

import org.bukkit.inventory.ItemStack;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Auction {
	
	public static TreeMap<Integer, AuctionData> auction = new TreeMap<>();
	
	public static void newOffer(String owner, float time, ItemStack itemdata, int price) {
		int offerid = getLastAuctionId()+1;
		auction.put(offerid, new AuctionData(owner, offerid, time, itemdata, price));
	}
	
	public static void deleteOffer(int id) {
		auction.remove(id);
	}
	
	public static AuctionData getAuction(int id) {
		return auction.getOrDefault(id, null);
	}dsadasda
	
	public static Integer getLastAuctionId() {
		return auction.lastKey();
	}
	
	public static class AuctionData {
		
		public int id;
		public float time;
		public ItemStack itemdata;
		
		public String lastbidder;
		public String owner;
		public int price;
		
		public AuctionData(String owner, int id, float time, ItemStack itemdata, int price) {
			this.owner = owner;
			this.id = id;
			this.time = time;
			this.itemdata = itemdata;
			this.price = price;
		}
		
		public String getLastBidder() {
			return this.lastbidder;
		}
		
		public String getOwner() {
			return this.owner;
		}
		
		public int getOfferId() {
			return this.id;
		}
		
		public float getTime() {
			return this.time;
		}
		
		public ItemStack getItemData() {
			return itemdata;
		}
		
		public int getPrice() {
			return this.price;
		}
		
		public void setLastBidder(String bidder) {
			this.lastbidder = bidder;
		}
		
		public void setTime(int time) {
			this.time = time;
		}
		
		public void setPrice(int price) {
			this.price = price;
		}
		
	}

}
