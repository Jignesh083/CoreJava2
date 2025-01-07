package JacksonAnyGetterExample;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Person{
	private String name;
	private int age;
	
    // A map to store dynamic properties 
	private Map<String,Object> extraProperties = new HashMap<>();
	
	public Person() {
		super();
	}
	
	public Person(String name,int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
    // Method to add extra properties dynamically
//	This is where we use @JsonAnySetter to de-serialize the map as additional properties
	@JsonAnySetter
	public void addExtraProperties(String key,Object value) {
		extraProperties.put(key, value);
	}
	
	
	// This is where we use @JsonAnyGetter to serialize the map as additional properties
		@JsonAnyGetter
		public Map<String,Object> getExtraProperties() {
			return extraProperties;
		}
	
}


public class JacksonAnyGetterEx {
	public static void main(String[] args) throws JsonProcessingException {
		Person person = new Person("Jignesh",30);
		
        // Add some dynamic properties to the person object
		person.addExtraProperties("address", "123 Main St");
        person.addExtraProperties("phone", "555-1234");
        person.addExtraProperties("email", "john.doe@example.com");
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        
        // Serialize the person object to JSON
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);
        
        
     // Deserialize the JSON back into a Person object
        Person deserializedPerson = objectMapper.readValue(json, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());
        System.out.println("Extra Properties: " + deserializedPerson.getExtraProperties());
        
	}

}
