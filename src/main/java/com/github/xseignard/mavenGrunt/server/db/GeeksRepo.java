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

	private MongoClient mongoClient;
	private DB geeksDatabase;

	public GeeksRepo() {
		try {
			mongoClient = new MongoClient(new MongoClientURI(
					"mongodb://localhost"));
			geeksDatabase = mongoClient.getDB("geeksDB");
		} catch (UnknownHostException e) {
			System.err.println("start your DB dumbass");
		}
	}

	public String find(String query, Integer limit, Integer skip) {
		if (limit == null) {
			limit = 12;
		}
		if (skip == null) {
			skip = 0;
		}

		BasicDBObject basicDBObject = new BasicDBObject();
		if (query != null && !"".equals(query)) {
			basicDBObject.put("likes", query);
		}

		DBCursor result = geeksDatabase.getCollection("geeks")
				.find(basicDBObject).limit(limit).skip(skip);
		List<DBObject> geeks = result.toArray();
		return JSON.serialize(geeks);
	}

}
