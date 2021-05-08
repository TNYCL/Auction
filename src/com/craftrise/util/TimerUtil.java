package com.craftrise.util;

import java.util.List;

import org.bukkit.Bukkit;

import com.craftrise.Main;
import com.craftrise.cache.Auction;
import com.craftrise.data.Status;

public class TimerUtil {
	
	@SuppressWarnings("deprecation")
	public static void auctionTimer() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
			public void run() {
				List<Auction> data = Main.getSpring().getAllAuction();
				for(Auction auction : data) {
					if(auction.getStatus() == Status.STARTED) {
						if(auction.getTime() == 1) {
							auction.setStatus(Status.FINISHED);
							DataUtil.updateAuction("auctionid", auction.getAuctionId(), "status", auction.getStatus());
						}
						if(auction.getTime() != 1) {
							auction.setTime(auction.getTime()-1);
							DataUtil.updateAuction("auctionid", auction.getAuctionId(), "time", auction.getTime());
						}
					}
				}
			}
		}, 20L, 20L);
	}

}
