package com.auction.utils;

import java.util.Map;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import com.auction.Main;
import com.auction.data.Message;
import com.auction.module.Auction;
import com.mongodb.client.FindIterable;

public class UtilAuction {

	@SuppressWarnings("deprecation")
	public static void createNewAuction(String owner, ItemStack itemdata, int price, int amount) {
		FindIterable<Document> document = Main.getMongo().getAuctionDatabase().find()
				.sort(new Document("auctionid", -1)).limit(1);
		
		int last_id = 0;
		if(Main.getSpring().mongoTemplate().getCollection("auction").count() == 0) {
			last_id = 1;
		} else {
			for (Document doc : document) {
				last_id = doc.getInteger("auctionid")+1;
			}
		}
		Auction auction = new Auction(owner, last_id, price);
		Map<String, Object> serialize = itemdata.serialize();
		serialize.replace("amount", amount);
		auction.setItemData(serialize);
		UtilData.setAuction(auction);
		Bukkit.getPlayer(owner).sendMessage(UtilChat.color(Message.OFFER_CREATED.replace("%id%", String.valueOf(last_id)).replace("%price%", String.valueOf(price))));
	}
	
	public static boolean isAuctionIdHave(int auctionid) {
		if(Main.getSpring().getAuctionData("auctionid", auctionid) == null) {
			return false;
		}
		return true;
	}

}
