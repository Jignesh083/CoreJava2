package JacksonAnnotationExample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class Person{

    private String name;

    @JsonProperty("Person_age") // Custom name in JSON for age
    private int age;

    @JsonIgnore  // This field will be ignored during serialization/deserialization
    private String email;

    public Person(String name,int age,String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(){
        super();
    }

    // Getters and Setters
    public String getName(){
        return name;
    }

    public  void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
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
        // Create a Person object
        Person person = new Person("Jignesh", 22, "example@gmail.com");

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("person.json"), person);
        System.out.println("Person object serialized to 'person.json'");

        // Deserialize the JSON file back into a Person object
        Person deserializedPerson = objectMapper.readValue(new File("person.json"),Person.class);
        System.out.println("Deserialized Person: "+deserializedPerson.getName()+", Age: "+deserializedPerson.getAge());

    }
}
