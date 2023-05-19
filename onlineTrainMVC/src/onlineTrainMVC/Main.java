package onlineTrainMVC;

import com.google.gson.Gson;

// import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		// Create a sample Java object
		Person person = new Person("John Doe", 30, "john.doe@example.com");

		// Create an instance of Gson
		Gson gson = new Gson();

		// Convert the Java object to JSON
		String json = gson.toJson(person);

		// Print the JSON string
		System.out.println(json);
	}
}

class Person {
	private String name;
	private int age;
	private String email;

	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	// Getters and setters (omitted for brevity)
}
