package JacksonInject;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class User {
	private String name;

	@JacksonInject
	private String country;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "Name: "+name+" Country: "+country;
	}
}

public class Example {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
        // JSON string without "country" field
		String json = """ 
				{
				"name":"Jignesh"
				}
				""";
		
        // Create an InjectableValues instance to supply the injected value
		InjectableValues.Std injectableValues = new InjectableValues.Std();
		injectableValues.addValue(String.class, "USA"); // Provide "USA" for country
		
		ObjectMapper objectMapper= new ObjectMapper();
		
		User user = objectMapper.reader(injectableValues).forType(User.class).readValue(json);
		System.out.println(user);
		
	} 
}
