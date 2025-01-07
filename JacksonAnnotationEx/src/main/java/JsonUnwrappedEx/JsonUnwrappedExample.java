package JsonUnwrappedEx;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;

class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and Setters
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

class Person {
    private String name;
    
    @JsonUnwrapped // Unwraps the Address object and includes its fields directly
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
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



public class JsonUnwrappedExample {
	public static void main(String[] args) throws Exception {
        Address address = new Address("123 Main St", "Springfield");
        Person person = new Person("John Doe", address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON with Unwrapped Fields: " + json);
    }
}
