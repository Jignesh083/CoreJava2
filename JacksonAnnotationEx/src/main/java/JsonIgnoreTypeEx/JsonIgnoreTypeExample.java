package JsonIgnoreTypeEx;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreType
class Address {
    private String street;
    private String city;

    // Constructor
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class PersonWithAddress {
    private String name;
    private Address address;

    // Constructor
    public PersonWithAddress(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}



public class JsonIgnoreTypeExample {
	public static void main(String[] args) throws JsonProcessingException {
		 // Create an Address object and a PersonWithAddress object
        Address address = new Address("123 Main St", "Anytown");
        PersonWithAddress person = new PersonWithAddress("Bob", address);

        // Serialize the PersonWithAddress object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);
	}

}
