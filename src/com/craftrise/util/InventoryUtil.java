package com.craftrise.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.craftrise.Main;
import com.craftrise.cache.Auction;
import com.craftrise.cache.Bidder;
import com.craftrise.data.Status;
import com.craftrise.inventory.AuctionInventory;
import com.craftrise.inventory.PagedData;
import com.craftrise.inventory.PagedInventory;
import com.craftrise.inventory.PagedItem;

public class InventoryUtil {

	public static void openStartedAuction(Player sender) {
		List<Auction> data = Main.getSpring().getAllAuction();
		List<ItemStack> itemlist = new ArrayList<>();
		for(Auction auction : data) {
			if(auction.getStatus() == Status.STARTED) {
				ItemStack items = new ItemStack(ItemStack.deserialize(auction.getItemData()));
				ItemMeta itemsMeta = items.getItemMeta();
				List<String> itemLore = new ArrayList<>();
				itemLore.add(ChatUtil.color("&eİhale numarası: &a" + String.valueOf(auction.getAuctionId()).toString()));
				itemLore.add(ChatUtil.color("&eSatıcı: &a" + auction.getOwner()));
				itemLore.add(ChatUtil.color("&eFiyat: &a" + String.valueOf(auction.getPrice())));
				if(auction.getBidder().isEmpty()) itemLore.add(ChatUtil.color("&eSon teklif veren: &aYOK")); 
				else itemLore.add(ChatUtil.color("&eSon teklif veren: &a" + auction.getLastBidder().getName()));
				itemLore.add(ChatUtil.color("&eKalan süre: &a" + Utils.getTime(auction.getTime()) + " Dakika"));
				itemLore.add("");
				itemLore.add(ChatUtil.color("&eBilgi için &6TIKLA."));
				itemsMeta.setLore(itemLore);
				items.setItemMeta(itemsMeta);
				itemlist.add(items);
			}
		}
		PagedInventory inventory = new PagedInventory(sender, 36, "İhale -> Devam eden", itemlist);
		ItemStack history = new ItemStack(Material.BOOK);
		ItemMeta historyMeta = history.getItemMeta();
		historyMeta.setDisplayName(ChatUtil.color("&aİhale geçmişi"));
		history.setItemMeta(historyMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-1, history));
		ItemStack own = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta ownMeta = own.getItemMeta();
		ownMeta.setDisplayName(ChatUtil.color("&aİhalelerim"));
		own.setItemMeta(ownMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-9, own));
		inventory.open();
		PagedData.deleteData(sender);
		PagedData.addData(sender, inventory);
	}
	
	public static void openFinishedAuction(Player sender) {
		List<Auction> data = Main.getSpring().getSelectedAuctionData("time", 1);
		List<ItemStack> itemlist = new ArrayList<>();
		for(Auction auction : data) {
			ItemStack items = new ItemStack(ItemStack.deserialize(auction.getItemData()));
			ItemMeta itemsMeta = items.getItemMeta();
			List<String> itemLore = new ArrayList<>();
			itemLore.add(ChatUtil.color("&eİhale numarası: &a" + String.valueOf(auction.getAuctionId())));
			itemLore.add(ChatUtil.color("&eSatıcı: &a" + auction.getOwner()));
			itemLore.add(ChatUtil.color("&eFiyat: &a" + String.valueOf(auction.getPrice())));
			if(auction.getBidder().isEmpty()) itemLore.add(ChatUtil.color("&eSatın alan: &aYOK")); 
			else itemLore.add(ChatUtil.color("&eSatın alan: &a" + auction.getLastBidder().getName()));
			itemLore.add("");
			itemLore.add(ChatUtil.color("&eBilgi için &6TIKLA."));
			itemsMeta.setLore(itemLore);
			items.setItemMeta(itemsMeta);
			itemlist.add(items);
		}
		PagedInventory inventory = new PagedInventory(sender, 36, "İhale -> Geçmiş", itemlist);
		ItemStack history = new ItemStack(Material.BOOK);
		ItemMeta historyMeta = history.getItemMeta();
		historyMeta.setDisplayName(ChatUtil.color("&aDevam eden ihaleler"));
		history.setItemMeta(historyMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-1, history));
		ItemStack own = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta ownMeta = own.getItemMeta();
		ownMeta.setDisplayName(ChatUtil.color("&aİhalelerim"));
		own.setItemMeta(ownMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-9, own));
		inventory.open();
		PagedData.deleteData(sender);
		PagedData.addData(sender, inventory);
	}
	
	public static void openOwnAuction(Player sender) {
		List<Auction> data = Main.getSpring().getSelectedAuctionData("owner", sender.getName());
		List<ItemStack> itemlist = new ArrayList<>();
		for(Auction auction : data) {
			if(auction.getStatus() == Status.STARTED) {
				ItemStack items = new ItemStack(ItemStack.deserialize(auction.getItemData()));
				ItemMeta itemsMeta = items.getItemMeta();
				List<String> itemLore = new ArrayList<>();
				itemLore.add(ChatUtil.color("&eİhale numarası: &a" + String.valueOf(auction.getAuctionId())));
				itemLore.add(ChatUtil.color("&eFiyat: &a" + String.valueOf(auction.getPrice())));
				if(auction.getBidder().isEmpty()) itemLore.add(ChatUtil.color("&eSon teklif veren: &aYOK")); 
				else itemLore.add(ChatUtil.color("&eSon teklif veren: &a" + auction.getLastBidder().getName()));
				itemLore.add(ChatUtil.color("&eKalan süre: &a" + Utils.getTime(auction.getTime())  + " Dakika"));
				itemLore.add("");
				itemLore.add(ChatUtil.color("&eBilgi için &6TIKLA."));
				itemsMeta.setLore(itemLore);
				items.setItemMeta(itemsMeta);
				itemlist.add(items);
			}
		}
		PagedInventory inventory = new PagedInventory(sender, 36, "İhalelerim -> Devam eden", itemlist);
		ItemStack history = new ItemStack(Material.BOOK);
		ItemMeta historyMeta = history.getItemMeta();
		historyMeta.setDisplayName(ChatUtil.color("&aİhale geçmişim"));
		history.setItemMeta(historyMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-1, history));
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(ChatUtil.color("&cGeri dön"));
		back.setItemMeta(backMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-9, back));
		inventory.open();
		PagedData.deleteData(sender);
		PagedData.addData(sender, inventory);
	}
	
	public static void openOwnAuctionHistory(Player sender) {
		List<Auction> data = Main.getSpring().getSelectedAuctionData("owner", sender.getName());
		List<ItemStack> itemlist = new ArrayList<>();
		for(Auction auction : data) {
			if(auction.getStatus() == Status.FINISHED || auction.getStatus() == Status.TAKED) {
				ItemStack items = new ItemStack(ItemStack.deserialize(auction.getItemData()));
				ItemMeta itemsMeta = items.getItemMeta();
				List<String> itemLore = new ArrayList<>();
				itemLore.add(ChatUtil.color("&eİhale numarası: &a" + String.valueOf(auction.getAuctionId())));
				itemLore.add(ChatUtil.color("&eFiyat: &a" + String.valueOf(auction.getPrice())));
				if(auction.getBidder().isEmpty()) itemLore.add(ChatUtil.color("&eSatın alan: &aYOK")); 
				else itemLore.add(ChatUtil.color("&eSatın alan: &a" + auction.getLastBidder().getName()));
				itemLore.add("");
				itemLore.add(ChatUtil.color("&eBilgi için &6TIKLA."));
				itemsMeta.setLore(itemLore);
				items.setItemMeta(itemsMeta);
				itemlist.add(items);
			}
		}
		PagedInventory inventory = new PagedInventory(sender, 36, "İhalelerim -> Geçmiş", itemlist);
		ItemStack started = new ItemStack(Material.BOOK);
		ItemMeta startedMeta = started.getItemMeta();
		startedMeta.setDisplayName(ChatUtil.color("&aDevam eden ihalelerim"));
		started.setItemMeta(startedMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-1, started));
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(ChatUtil.color("&cGeri dön"));
		back.setItemMeta(backMeta);
		inventory.addCustomItem(new PagedItem(inventory.getSize()-9, back));
		inventory.open();
		PagedData.deleteData(sender);
		PagedData.addData(sender, inventory);
	}
	
	public static void openAuctionDetailsFromId(Player sender, Auction auction) {
		Inventory inventory = Bukkit.createInventory(null, 9, "İncele -> " + auction.getAuctionId());
		ItemStack item = ItemStack.deserialize(auction.getItemData());
		ItemMeta itemMeta = item.getItemMeta();
		AuctionInventory.deleteData(sender);
		List<String> itemLore = new ArrayList<>();
		itemLore.add(ChatUtil.color("&eFiyat: &a" + String.valueOf(auction.getPrice())));
		itemLore.add("");
		if(auction.getBidder().isEmpty()) {
			itemLore.add(ChatUtil.color("&eSon teklif veren: &aYOK"));
		} else {
			for(Bidder bidder : auction.getBidder()) {
				itemLore.add(ChatUtil.color("&b" + bidder.getTime() + "&e - &a" + bidder.getName() + "&e -> &a" + bidder.getPrice()));
			}
		}
		if(auction.getStatus() == Status.STARTED) {
			if(auction.getOwner().equals(sender.getName())) {
				ItemStack delete = new ItemStack(Material.REDSTONE_BLOCK);
				ItemMeta deleteMeta = delete.getItemMeta();
				deleteMeta.setDisplayName(ChatUtil.color("&cİhaleyi iptal et!"));
				delete.setItemMeta(deleteMeta);
				inventory.setItem(8, delete);
			} else {
				ItemStack bid500 = new ItemStack(Material.WOOL, 1, (byte) 5);
				ItemMeta bid500Meta = bid500.getItemMeta();
				bid500Meta.setDisplayName(ChatUtil.color("&aFiyatı arttır: &e500 dinar"));
				bid500.setItemMeta(bid500Meta);
				inventory.setItem(8, bid500);
			}
		}
		if(auction.getStatus() == Status.FINISHED) {
			if(auction.getOwner().equals(sender.getName())) {
				if(auction.getBidder().size() == 0) {
					ItemStack take = new ItemStack(Material.EMERALD);
					ItemMeta takeMeta = take.getItemMeta();
					takeMeta.setDisplayName(ChatUtil.color("&aEşyayı teslim al!"));
					take.setItemMeta(takeMeta);
					inventory.setItem(8, take);
				}
			}
		}
		if(auction.getStatus() == Status.TAKED) {
			if(auction.getOwner().equals(sender.getName())) {
				ItemStack take = new ItemStack(Material.REDSTONE);
				ItemMeta takeMeta = take.getItemMeta();
				takeMeta.setDisplayName(ChatUtil.color("&cBu eşyayı zaten teslim almışsın!"));
				take.setItemMeta(takeMeta);
				inventory.setItem(8, take);
			}
		}
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(ChatUtil.color("&cİhale listesine geri dön"));
		back.setItemMeta(backMeta);
		inventory.setItem(0, back);
		AuctionInventory.addData(sender, new AuctionInventory(auction.getAuctionId(), auction.getPrice()));
		itemMeta.setLore(itemLore);
		item.setItemMeta(itemMeta);
		inventory.setItem(4, item);
		sender.openInventory(inventory);
	}

}
