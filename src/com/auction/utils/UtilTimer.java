package com.auction.utils;

import java.util.List;

import org.bukkit.Bukkit;

import com.auction.Main;
import com.auction.data.Status;
import com.auction.module.Auction;

public class UtilTimer {
	
	@SuppressWarnings("deprecation")
	public static void auctionTimer() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
			public void run() {
				List<Auction> data = Main.getSpring().getAllAuction();
				for(Auction auction : data) {
					if(auction.getStatus() == Status.STARTED) {
						if(auction.getTime() == 1) {
							auction.setStatus(Status.FINISHED);
							UtilData.updateAuction("auctionid", auction.getAuctionId(), "status", auction.getStatus());
						}
						if(auction.getTime() != 1) {
							auction.setTime(auction.getTime()-1);
							UtilData.updateAuction("auctionid", auction.getAuctionId(), "time", auction.getTime());
						}
					}
				}
			}
		}, 20L, 20L);
	}

}
