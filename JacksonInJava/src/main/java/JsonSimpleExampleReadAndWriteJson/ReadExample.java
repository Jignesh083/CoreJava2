package JsonSimpleExampleReadAndWriteJson;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

 class Person {
    private String name;
    private int age;
    private String city;

    // Constructor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


    public Person() {
        super();
        // TODO Auto-generated constructor stub
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

public class ReadExample{
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "D:\\Jignesh\\JacksonInJava\\src\\main\\java\\JsonSimpleExampleReadAndWriteJson\\input.json";

        List<Person> persons = objectMapper.readValue(new File(filePath), new TypeReference<List<Person>>() {});

        // Print the list of person objects
        for (Person person : persons) {
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("City: " + person.getCity());
            System.out.println("---------------");
        }

    }
}
