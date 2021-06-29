package com.auction.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	
	public Mongo() {
		try {
			MongoClientURI uri = new MongoClientURI("mongodb://tnycl:987547@185.255.93.193:27017/?authSource=admin");
			this.mongoClient = new MongoClient(uri);
			this.database = this.mongoClient.getDatabase("admin");
			System.out.println("Mongo - Baglanti kuruldu!");
		} catch (Exception e) {
			System.out.println("Baglanti saglanamadi + " + e);
		}
	}
	
	public MongoCollection<Document> getAuctionDatabase() {
		return this.database.getCollection("auction");
	}
	
	public MongoDatabase getDatabase() {
		return this.database;
	}

}
