package com.craftrise.command;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.craftrise.Main;
import com.craftrise.cache.Auction;
import com.craftrise.data.Message;
import com.craftrise.util.AuctionUtil;
import com.craftrise.util.ChatUtil;
import com.craftrise.util.InventoryUtil;
import com.craftrise.util.Utils;

public class SubCommand {

	public static void openAuctionHouse(Player sender) {
		InventoryUtil.openStartedAuction(sender);
	}
	
	public static void openAuctionFromId(Player sender, int auctionid) {
		if(Utils.isString(String.valueOf(auctionid))) {
			ChatUtil.message(sender, Message.AUCTION_ID_NOT_INTEGER);
			return;
		}
		if(!Utils.isAuctionIdHave(auctionid)) {
			ChatUtil.message(sender, Message.NOT_FOUND_AUCTION_ID.replace("%id%", String.valueOf(auctionid)));
			return;
		}
		Auction data = Main.getSpring().getAuctionData("auctionid", auctionid);
		InventoryUtil.openAuctionDetailsFromId(sender, data);
	}
	
	public static void createAuction(Player sender, int amount, int price) {
		if(sender.getItemInHand().getType() == Material.AIR) {
			ChatUtil.message(sender, Message.NOT_FOUND_ITEM_IN_HAND);
			return;
		}
		int real_amount = sender.getItemInHand().getAmount();
		if(amount > real_amount) {
			ChatUtil.message(sender, Message.AMOUNT_GREATER.replace("%amount%", String.valueOf(real_amount)));
			return;
		}
		if(amount == 0) {
			ChatUtil.message(sender, Message.AMOUNT_EQUALS_ZERO);
			return;
		}
		AuctionUtil.createNewAuction(sender.getName(), sender.getItemInHand(), price, amount);
		if(amount == real_amount) {
			sender.setItemInHand(null);
		} else {
			sender.getItemInHand().setAmount(real_amount-amount);	
		}
	}
	
}
