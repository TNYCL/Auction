package com.craftrise;

import org.bukkit.plugin.java.JavaPlugin;

import com.craftrise.sql.Connect;

public class Main extends JavaPlugin {

	public static Main instance;
	
	public void onEnable() {
		instance = this;
		registerCommands();
		Connect.connectDatabase();
		System.out.println("["+getDescription().getName()+"] Aktif!");
	}
	
	public void registerCommands() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
