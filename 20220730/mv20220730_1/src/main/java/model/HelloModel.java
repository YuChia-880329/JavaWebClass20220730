package model;

import java.util.HashMap;
import java.util.Map;

public class HelloModel {

	private Map<String, String> messages;
	
	
	private HelloModel() {
		messages = new HashMap<>();
		messages.put("John", "Hello");
		messages.put("Ray", "Welcome");
		messages.put("Vincent", "Hi");
	}
	
	public String sayHello(String user) {
		String message = messages.get(user);
		return message + "," + user + "!";
	}
	
	
	static HelloModel helloModelInit() {
		return new HelloModel();
	}
}
