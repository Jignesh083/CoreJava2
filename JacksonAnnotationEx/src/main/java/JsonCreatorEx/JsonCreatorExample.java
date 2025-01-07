package JsonCreatorEx;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Person{
	private String name;
	private int age;
	
	//Don't make default Constructor due De-Serialized
//	Person(){
//		
//	}
	
    // Non-default constructor	
	@JsonCreator
	public Person(@JsonProperty("name") String name,@JsonProperty("age") int age) {
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
	
	
	public String toString() {
		return "Name: "+name+" Age: "+age;
	}
}



public class JsonCreatorExample {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = """
				{
				"name" : "Jignesh",
				"age" : 21
				}""";

		ObjectMapper objectMapper = new ObjectMapper();
		
		Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);

	}

}
