package com.auction.utils;

public class UtilString {

	public static boolean isString(String auctionid) {
		try {
			Integer.parseInt(auctionid);
			return false;
		} catch(NumberFormatException e) {
			return true;
		}
	}
	
}
