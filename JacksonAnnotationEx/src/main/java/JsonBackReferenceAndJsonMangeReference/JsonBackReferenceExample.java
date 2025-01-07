package JsonBackReferenceAndJsonMangeReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Address{
	private String street;
	private String city;
	
	@JsonBackReference
	private Person person; // Back reference to Person, this won't be serialized.
	
	
	public Address(String street,String city,Person person) {
		this.street = street;
		this.city = city;
		this.person = person;
	}
	
	
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
	
	
	 public Person getPerson() {
	        return person;
	    }

	 public void setPerson(Person person) {
	        this.person = person;
	    }
}


class Person{
	private String name;
	private int age;
	
	@JsonManagedReference 
	private Address address;  // Managed reference to Address, this will be serialized.
	
	
	public Person(String name,int age,Address address) {
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
	
	
	public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class JsonBackReferenceExample {
	public static void main(String[] args) throws JsonProcessingException {
		
        // Create Person and Address objects with circular reference
		Person person = new Person("Rahul",30,null);
		Address address = new Address("xyz", "Ahm", person);
		person.setAddress(address);
		
		ObjectMapper objectMapper = new ObjectMapper();

        // Serialize the person object to JSON
		String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);

	}
}
