package com.craftrise.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			//Player player = (Player) sender;dfg
			if(args.length == 0) {
				
			} else if(args[0].equalsIgnoreCase("aç")) {
				
			} else {
				
			}
		}
		return false;
	}

}
