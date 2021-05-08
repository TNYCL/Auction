package com.craftrise.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrise.data.Message;
import com.craftrise.util.ChatUtil;
import com.craftrise.util.Utils;

public class AuctionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 0) {
				SubCommand.openAuctionHouse(player);
			} else if(args[0].equalsIgnoreCase("yardim") || args[0].equalsIgnoreCase("help")) {
				player.sendMessage(Message.COMMAND_INFO);
			} else if(args[0].equalsIgnoreCase("baþlat") || args[0].equalsIgnoreCase("start")) {
				if(args.length != 1) {
					if(!Utils.isString(args[1])) {
						if(args.length != 2) {
							if(!Utils.isString(args[2])) {
								SubCommand.createAuction(player, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
							} else {
								ChatUtil.message(player, Message.ENTER_CORRECTLY_VALUE);
							}
						} else {
							player.sendMessage(Message.COMMAND_INFO);
						}
					} else {
						ChatUtil.message(player, Message.ENTER_CORRECTLY_VALUE);
					}
				} else {
					player.sendMessage(Message.COMMAND_INFO);
				}
			} else if(args[0].equalsIgnoreCase("incele") || args[0].equalsIgnoreCase("show")) {
				if(args.length != 1) {
					if(Utils.isString(args[1])) {
						ChatUtil.message(player, Message.AUCTION_ID_NOT_INTEGER);
					} else {
						SubCommand.openAuctionFromId(player, Integer.parseInt(args[1]));
					}
				} else {
					player.sendMessage(Message.COMMAND_INFO);
				}
			} else {
				player.sendMessage(Message.COMMAND_INFO);
			}
		}
		return false;
	}

}
