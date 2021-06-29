package com.auction.mongo;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.auction.module.Auction;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Spring {
	
	public MongoClient mongoClient = null;
	public MongoTemplate mongoTemplate = null;
	
	public Spring() {
		if(createMongoClient()) System.out.println("Mongo Spring Aktif!");
		else System.out.println("Mongo Spring Deaktif!");
	}
	
	@Bean
	public boolean createMongoClient() {
		try {
			mongoClient = MongoClients.create("mongodb://tnycl:987547@185.255.93.193:27017/?authSource=admin");
			mongoTemplate = new MongoTemplate(mongoClient, "admin");
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Bean
	public MongoClient mongoClient() {
		return mongoClient;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return mongoTemplate;
	}

	public Auction getAuctionData(String key, int value) {
		return mongoTemplate().findOne(Query.query(Criteria.where(key).is(value)), Auction.class);
	}
	
	public Auction getAuctionData(String key, String value) {
		return mongoTemplate().findOne(Query.query(Criteria.where(key).is(value)), Auction.class);
	}
	
	public List<Auction> getSelectedAuctionData(String key, Object value) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoTemplate().find(query, Auction.class);
	}
	
	public List<Auction> getSelectedAuctionData(Query query) {
		return mongoTemplate().find(query, Auction.class);
	}
	
	public List<Auction> getAllAuction() {
		return mongoTemplate().findAll(Auction.class);
	}

}




















