package JacksonAnnotationInsideEx;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class Person {
    //Regular java fields
    private String name;

    @JsonProperty("person_age") // change the JSON key for 'age'
    private int age;

    @JsonIgnore  // This field will be ignored during serialization and deserialization
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Only include 'email' if it's not null
    private String email;
 

    public Person(){
        super();
    }

    public Person(String name,int age,String password,String email){
        this.name = name;
        this.age = age;
        this.password = password;
        this.email = email;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }


    public void setAge(int age){
        this.age = age;
    }


    public String getPassword(){
        return password;
    }


    public void setPassword(String password){
        this.password = password;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

public class Example {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Rahul", 45, "002110", "xyz@gmail.com");

        // Create ObjectMapper for serialization and deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize the Person object to JSON
        objectMapper.writeValue(new File("person.json"), person);
        System.out.println("Person object serialized to 'person.json'");

        // Deserialize the JSON back to a Person object
        Person deserializedPerson = objectMapper.readValue(new File("person.json"), Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", Age: " + deserializedPerson.getAge());



    }
}
