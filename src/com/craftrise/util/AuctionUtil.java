package com.craftrise.util;

import java.util.Map;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import com.craftrise.Main;
import com.craftrise.cache.Auction;
import com.craftrise.data.Message;
import com.mongodb.client.FindIterable;

public class AuctionUtil {

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
		DataUtil.setAuction(auction);
		Bukkit.getPlayer(owner).sendMessage(ChatUtil.color(Message.OFFER_CREATED.replace("%id%", String.valueOf(last_id)).replace("%price%", String.valueOf(price))));
	}

}
