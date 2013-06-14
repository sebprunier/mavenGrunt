package com.github.xseignard.mavenGrunt.server;

import spark.Spark;

import com.github.xseignard.mavenGrunt.server.db.GeeksRepo;

import spark.*;
import spark.servlet.SparkApplication;

public class Server implements SparkApplication {

	public void init() {				
		Spark.get(new Route("/geek/likes/:like?") {
			@Override
			public Object handle(Request request, Response response) {
				String query = request.params(":like");
				return new GeeksRepo().find(
						query,
						request.queryMap().get("limit").integerValue(),
						request.queryMap().get("skip").integerValue());
			}
		});
	}

}
