package com.craftrise.listener;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.craftrise.Main;
import com.craftrise.cache.Auction;
import com.craftrise.cache.Bidder;
import com.craftrise.data.Message;
import com.craftrise.data.Status;
import com.craftrise.inventory.AuctionInventory;
import com.craftrise.inventory.PagedData;
import com.craftrise.inventory.PagedInventory;
import com.craftrise.util.ChatUtil;
import com.craftrise.util.DataUtil;
import com.craftrise.util.InventoryUtil;
import com.craftrise.util.Utils;

public class AuctionListener implements Listener {
	
	@EventHandler
	public void auctionHouseButton(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if(item == null) return;
		ItemMeta itemMeta = item.getItemMeta();
		if(itemMeta == null) return;
		String selectedItemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if(item.getType().equals(Material.BOOK)) {
			// public
			if(selectedItemName.equalsIgnoreCase("Ýhale geçmiþi")) {
				InventoryUtil.openFinishedAuction(player);
			}
			if(selectedItemName.equalsIgnoreCase("Devam eden ihaleler")) {
				InventoryUtil.openStartedAuction(player);
			}
			// private
			if(selectedItemName.equalsIgnoreCase("Ýhale geçmiþim")) {
				InventoryUtil.openOwnAuctionHistory(player);
			}
			if(selectedItemName.equalsIgnoreCase("Devam eden ihalelerim")) {
				InventoryUtil.openOwnAuction(player);
			}
		}
		if(item.getType().equals(Material.BOOK_AND_QUILL)) {
			if(selectedItemName.equalsIgnoreCase("Ýhalelerim")) {
				InventoryUtil.openOwnAuction(player);
			}
		}
		if(item.getType().equals(Material.BARRIER)) {
			if(selectedItemName.equalsIgnoreCase("Geri dön")) {
				InventoryUtil.openStartedAuction(player);
			}
		}
	}
	
	@EventHandler
	public void auctionHouseItem(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if(item == null) return;
		ItemMeta itemMeta = item.getItemMeta();
		if(itemMeta == null) return;
		String selectedItemName = ChatColor.stripColor(itemMeta.getDisplayName());
		String inventoryName = event.getInventory().getName();
		List<String> itemLore = itemMeta.getLore();
		if(inventoryName.equals("Ýhale -> Devam eden") || inventoryName.equals("Ýhale -> Geçmiþ")) {
			if(itemLore == null) return;
			String auctionid = ChatColor.stripColor(itemLore.get(0).replace("Ýhale numarasý: ", ""));
			Auction auction = Main.getSpring().getAuctionData("auctionid", Integer.parseInt(auctionid));
			InventoryUtil.openAuctionDetailsFromId(player, auction);
			event.setCancelled(true);
		}
		if(inventoryName.equals("Ýhalelerim -> Devam eden") || inventoryName.equals("Ýhalelerim -> Geçmiþ")) {
			if(itemLore == null) return;
			String auctionid = ChatColor.stripColor(itemLore.get(0).replace("Ýhale numarasý: ", ""));
			Auction auction = Main.getSpring().getAuctionData("auctionid", Integer.parseInt(auctionid));
			InventoryUtil.openAuctionDetailsFromId(player, auction);
			event.setCancelled(true);
		}
		if(inventoryName.equals("Ýncele -> " + AuctionInventory.getData(player).getAuctionId())) {
			Auction auction = Main.getSpring().getAuctionData("auctionid", AuctionInventory.getData(player).getAuctionId());
			event.setCancelled(true);
			if(!event.getCurrentItem().getItemMeta().hasDisplayName()) {
				return;
			}
			if(item.getType().equals(Material.WOOL)) {
				if(auction.getStatus() == Status.FINISHED && auction.getStatus() == Status.TAKED) {
					player.closeInventory();
					ChatUtil.message(player, Message.ERROR);
					return;
				}
				if(selectedItemName.equalsIgnoreCase("Fiyatý arttýr: 500 dinar")) {
					auction.setPrice(auction.getPrice()+500);
					Bidder bidder = new Bidder(player.getName(), auction.getPrice(), Utils.getTime(auction.getTime()));
					auction.addLastBidder(bidder);
					DataUtil.updateAuction("auctionid", auction.getAuctionId(), "price", auction.getPrice());
					DataUtil.updateAuction("auctionid", auction.getAuctionId(), "lastbidder", auction.getBidder());
					ChatUtil.message(player, Message.OFFER_BID.replace("%id%", String.valueOf(auction.getAuctionId()).replace("%price%", String.valueOf(auction.getPrice()))));
					if(Bukkit.getPlayer(auction.getOwner()) != null) {
						ChatUtil.message(Bukkit.getPlayer(auction.getOwner()), Message.OFFER_BID_OWNER.replace("%id%", String.valueOf(auction.getAuctionId()).replace("%player%", player.getName()).replace("%price%", String.valueOf(auction.getPrice()))));
					}
				}
				player.closeInventory();
				AuctionInventory.deleteData(player);
			}
			if(item.getType().equals(Material.BARRIER)) {
				if(selectedItemName.equalsIgnoreCase("Ýhale listesine geri dön")) {
					PagedInventory inventory = PagedData.getData(player);
					inventory.open();
				}
			}
			if(item.getType().equals(Material.REDSTONE_BLOCK)) {
				if(auction.getStatus() != Status.STARTED) {
					player.closeInventory();
					ChatUtil.message(player, Message.ERROR);
					return;
				}
				if(selectedItemName.equalsIgnoreCase("Ýhaleyi iptal et!")) {
					PagedInventory inventory = PagedData.getData(player); // ihale iptal edildi yazýsý ekle ve datayý sil!
					inventory.open();
				}
			}
		}
	}
	
}
