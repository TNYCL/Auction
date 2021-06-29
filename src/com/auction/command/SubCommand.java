package com.auction.command;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.auction.Main;
import com.auction.data.Message;
import com.auction.module.Auction;
import com.auction.util.Utils;
import com.auction.utils.UtilAuction;
import com.auction.utils.UtilChat;
import com.auction.utils.UtilInventory;

public class SubCommand {

	public static void openAuctionHouse(Player sender) {
		UtilInventory.openStartedAuction(sender);
	}
	
	public static void openAuctionFromId(Player sender, int auctionid) {
		if(Utils.isString(String.valueOf(auctionid))) {
			UtilChat.message(sender, Message.AUCTION_ID_NOT_INTEGER);
			return;
		}
		if(!Utils.isAuctionIdHave(auctionid)) {
			UtilChat.message(sender, Message.NOT_FOUND_AUCTION_ID.replace("%id%", String.valueOf(auctionid)));
			return;
		}
		Auction data = Main.getSpring().getAuctionData("auctionid", auctionid);
		UtilInventory.openAuctionDetailsFromId(sender, data);
	}
	
	public static void createAuction(Player sender, int amount, int price) {
		if(sender.getItemInHand().getType() == Material.AIR) {
			UtilChat.message(sender, Message.NOT_FOUND_ITEM_IN_HAND);
			return;
		}
		int real_amount = sender.getItemInHand().getAmount();
		if(amount > real_amount) {
			UtilChat.message(sender, Message.AMOUNT_GREATER.replace("%amount%", String.valueOf(real_amount)));
			return;
		}
		if(amount == 0) {
			UtilChat.message(sender, Message.AMOUNT_EQUALS_ZERO);
			return;
		}
		UtilAuction.createNewAuction(sender.getName(), sender.getItemInHand(), price, amount);
		if(amount == real_amount) {
			sender.setItemInHand(null);
		} else {
			sender.getItemInHand().setAmount(real_amount-amount);	
		}
	}
	
}
