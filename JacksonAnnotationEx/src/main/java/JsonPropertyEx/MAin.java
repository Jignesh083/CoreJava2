package JsonPropertyEx;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

class Person{
    
    @JsonProperty("full_name") // Renames 'name' to 'full_name' in JSON
    private String name;

    @JsonProperty("age_years") // Renames 'age' to 'age_years' in JSON
    private int age;

    // Constructor, getters, and setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}



public class MAin {
	 public static void main(String[] args) throws Exception {
	        // Create a Person object
	        Person person = new Person("John Doe", 30);

	        // Serialize the object to JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(person);

	        System.out.println(json);
	    }
}
