package com.craftrise.util;

import com.craftrise.Main;

public class Utils {
	
	public static boolean isAuctionIdHave(int auctionid) {
		if(Main.getSpring().getAuctionData("auctionid", auctionid) == null) {
			return false;
		}
		return true;
	}
	
	public static boolean isString(String auctionid) {
		try {
			Integer.parseInt(auctionid);
			return false;
		} catch(NumberFormatException e) {
			return true;
		}
	}
	
	public static String getTime(int time) {
		int minute = (time%3600)/60;
		int second = (time%3600)%60;
		String data = String.format("%d:%02d", minute, second);
		return data;
	}

}
