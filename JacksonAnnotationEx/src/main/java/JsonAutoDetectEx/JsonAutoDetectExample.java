package JsonAutoDetectEx;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
class Person{
	protected String name;
	public int age;
	
	Person(){
		
	}
	
	Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
}



public class JsonAutoDetectExample {
	public static void main(String[] args) throws JsonProcessingException {
		Person person = new Person("Jignesh",30);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);		
	}
}
