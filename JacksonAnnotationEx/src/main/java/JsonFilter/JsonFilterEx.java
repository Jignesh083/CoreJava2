package JsonFilter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@JsonFilter("person_filter")
class Person{
	private String name;
	private int age;
	private String address;
	
	
	public Person(String name,int age,String address) {
		this.name = name;
		this.age = age;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}



public class JsonFilterEx {
	
	public static void main(String[] args) throws JsonProcessingException {
		Person person1 = new Person("Alice", 25, "New York");
		Person person2 = new Person("Bob", 30, "Los Angeles"); 
 		
		
		ObjectMapper objectMapper = new ObjectMapper();
	
		
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.addFilter("person_filter",
	            // Example of filtering fields based on a custom condition (e.g., only serialize "age" and "name")
				com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept("address"));
		
		
	
        // Apply the filter and serialize
		String json = objectMapper.writer(filters).writeValueAsString(person1);
		System.out.println(json);
		
		
        // Another object serialization with a different filter
		json =objectMapper.writer(filters).writeValueAsString(person2);
		System.out.println(json);
		
	}
}
