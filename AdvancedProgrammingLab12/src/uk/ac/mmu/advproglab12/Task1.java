package uk.ac.mmu.advproglab12;

import static spark.Spark.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import spark.Request;
import spark.Response;
import spark.Route;

public class Task1 {

	public static void main(String[] args) {
		
		System.setProperty("org.eclipse.jetty.until.log.announce", "false");
		System.setProperty("org.eclipse.jetty.until.LEVEL", "OFF");
		
		port(8080);
		
		get("/hello", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				return "<html><head></head><body><p>Hello, HTTP World!</p><body></html>";
			}
		});
		
		get("/somethingelse", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				return "some other content...";
				
			}
	
		});
		
		get("/somethingelse", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				return "some other content...";
				
			}
	
		});
		
		get("/runtime", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				int rt = Runtime.getRuntime().availableProcessors();
				return "Runtime is: " + rt;
				
			}
	
		});
		
		get("/files", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				Path currentPath = Paths.get("");
				String s = currentPath.toAbsolutePath().toString();
				return "Current absolute path is: " + s;
				
			}
	
		});
		
		notFound("<html><head></head><body><h1>404 Not Found</h1><p>Page not made!</p></body></html>");
	}

}
