package JsonGetterJsonSetterEx;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class User{
	private String firstName;
	private String lastName;
	
	
	User(){
		
	}
	
	
	public User(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


    // JsonGetter and JsonSetter for name 
	@JsonSetter("first_Name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@JsonGetter("last_Name")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}


public class JsonGetterSetterExample {
	public static void main(String[] args) throws Exception {
		User user = new User("Jignesh","Prajapati");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = objectMapper.writeValueAsString(user);
		System.out.println("Serialized JSON: " + json);
				
		
		String jsonInput ="""
				{
				"first_Name":"Rahul",
				"last_Name": "sosa"
				}
				""";
		
		
		User deserialized = objectMapper.readValue(jsonInput, User.class);
        System.out.println("Deserialized User: " + deserialized.getFirstName() + " " + deserialized.getLastName());
        
		}
	}