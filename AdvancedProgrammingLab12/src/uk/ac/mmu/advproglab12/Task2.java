package uk.ac.mmu.advproglab12;

import static spark.Spark.*;


import spark.Request;
import spark.Response;
import spark.Route;

public class Task2 {

	public static void main(String[] args) {
		
		System.setProperty("org.eclipse.jetty.until.log.announce", "false");
		System.setProperty("org.eclipse.jetty.until.LEVEL", "OFF");
		
		port(8080);
		
		get("/colour", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				String name = request.queryParams("name");
				String colour = request.queryParams("colour");
				
				return name + "<p style=\"color: "+ colour +"\">favourite colour is " + colour + "</p>";

			}
		});
		
		post("/postcolour", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				String name = request.queryParams("name");
				String colour = request.queryParams("colour");
				
				return name + "<p style=\"color: "+ colour +"\">favourite colour is " + colour + "</p>";

			}
		});
		
		
		
		notFound("<html><head></head><body><h1>404 Not Found</h1><p>Page has not beem made!</p></body></html>");
	}

}
