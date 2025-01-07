package JsonIgnorePropertiesEx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties({"age", "address"})
class Employee {
    private String name;
    private int age;
    private String address;

    // Constructor
    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


public class JsonIgnorePropertiesExample {
		public static void main(String[] args) throws Exception {
	        // Create an Employee object
	        Employee employee = new Employee("Alice", 28, "123 Main St");

	        // Serialize the Employee object to JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(employee);
	        System.out.println("Serialized JSON: " + json);
	}
}
