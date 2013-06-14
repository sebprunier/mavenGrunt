package com.github.xseignard.mavenGrunt.server.db;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

public class GeeksRepo {

	MongoClient mongoClient;
	DB geeksDatabase;

	public GeeksRepo() {
		try {
			mongoClient = new MongoClient(new MongoClientURI(
					"mongodb://localhost"));
			geeksDatabase = mongoClient.getDB("geeksDB");
		} catch (UnknownHostException e) {
			System.out.println("start your DB dumbass");
		}
	}

	public String find(String query, Integer limit, Integer skip) {
		if (limit == null) {
			limit = 12;
		}
		if (skip == null) {
			skip = 0;
		}
		DBCursor result = geeksDatabase.getCollection("geeks")
				.find(new BasicDBObject("likes", query))
				.limit(limit)
				.skip(skip);
		List<DBObject> gees = result.toArray();
		return JSON.serialize(gees);
	}

}
