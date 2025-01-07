package JSONIgnoredExJsonIgnoreEx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
    private String name;

    @JsonIgnore
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
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
}



public class JsonIgnoreExample {
	public static void main(String[] args) throws JsonProcessingException {
		 // Create a Person object
        Person person = new Person("John", 30);

        // Serialize the Person object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);
	}
}
