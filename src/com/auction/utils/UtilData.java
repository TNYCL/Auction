package com.auction.utils;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.auction.Auction;
import com.auction.module.Auction;

public class UtilData {
	
	public static void setAuction(Auction auction) {
		Auction.getSpring().mongoTemplate().insert(auction);
	}
	
	public static void updateAuction(String where, Object is, String key, Object value) {
		Query query = new Query();
		query.addCriteria(Criteria.where(where).is(is));
		Update update = new Update();
		update.set(key, value);
		Auction.getSpring().mongoTemplate().updateFirst(query, update, Auction.class);
	}
	
}
