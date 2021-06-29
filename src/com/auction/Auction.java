package com.auction;

import org.bukkit.plugin.java.JavaPlugin;

import com.auction.command.AuctionCommand;
import com.auction.listener.AuctionListener;
import com.auction.mongo.Mongo;
import com.auction.mongo.Spring;
import com.auction.utils.UtilTimer;

public class Auction extends JavaPlugin {

	private static Auction instance;
	private static Mongo mongo;
	private static Spring spring;
	
	public void onEnable() {
		instance = this;
		mongo = new Mongo();
		spring = new Spring();
		registerCommands();
		registerListener();
		System.out.println("["+getDescription().getName()+"] Aktif!");
		UtilTimer.auctionTimer();
	}
	
	public void registerCommands() {
		getCommand("ihale").setExecutor(new AuctionCommand());
	}
	
	public void registerListener() {
		getServer().getPluginManager().registerEvents(new AuctionListener(), this);
	}
	
	public static Auction getInstance() {
		return instance;
	}
	
	public static Mongo getMongo() {
		return mongo;
	}
	
	public static Spring getSpring() {
		return spring;
	}
	
}
