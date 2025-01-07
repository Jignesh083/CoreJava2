package JsonPropertyOrderEx;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder({ "id", "name", "age"}) // Specifies the order of the properties in the serialized JSON
class Employee {
    
    private int id;
    private String name;
    private int age;

    // Constructor
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}




public class JsonPropertyOrderExample {
	public static void main(String[] args) throws Exception {
	   
		// Create an Employee object
		Employee employee = new Employee(1, "Alice", 30);

		// Serialize the object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(employee);

		System.out.println(json);
	}
}



//@JsonProperty allows you to control how a field is represented in the JSON (e.g., renaming fields, marking fields as required, etc.).
//@JsonPropertyOrder allows you to control the order of properties in the serialized JSON.
