package com.auction.utils;

public class UtilTime {
	
	public static String getTime(int time) {
		int minute = (time%3600)/60;
		int second = (time%3600)%60;
		String data = String.format("%d:%02d", minute, second);
		return data;
	}

}
