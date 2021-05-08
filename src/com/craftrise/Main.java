package com.craftrise;

import org.bukkit.plugin.java.JavaPlugin;

import com.craftrise.command.AuctionCommand;
import com.craftrise.listener.AuctionListener;
import com.craftrise.mongo.Mongo;
import com.craftrise.mongo.Spring;
import com.craftrise.util.TimerUtil;

public class Main extends JavaPlugin {

	private static Main instance;
	private static Mongo mongo;
	private static Spring spring;
	
	public void onEnable() {
		instance = this;
		mongo = new Mongo();
		spring = new Spring();
		registerCommands();
		registerListener();
		System.out.println("["+getDescription().getName()+"] Aktif!");
		TimerUtil.auctionTimer();
	}
	
	public void registerCommands() {
		getCommand("ihale").setExecutor(new AuctionCommand());
	}
	
	public void registerListener() {
		getServer().getPluginManager().registerEvents(new AuctionListener(), this);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static Mongo getMongo() {
		return mongo;
	}
	
	public static Spring getSpring() {
		return spring;
	}
	
}
