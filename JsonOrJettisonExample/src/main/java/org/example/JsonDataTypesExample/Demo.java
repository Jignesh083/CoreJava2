package org.example.JsonDataTypesExample;

import com.google.gson.Gson;


import java.util.List;


class Address {
                String street;
                String city;
        }

        class Person {
                String name;
                int age;
                boolean isStudent;
                Address address;
                List<String> phoneNumbers;
        }
public class Demo {
        public static void main(String[] args) {
                        // Creating a Person object
                        Person person = new Person();
                        person.name = "John Doe";
                        person.age = 30;
                        person.isStudent = false;

                        // Setting the address object
                        Address address = new Address();
                        address.street = "123 Main St";
                        address.city = "Anytown";
                        person.address = address;

                        // Adding phone numbers to the list
                        person.phoneNumbers = List.of("123-456-7890", "987-654-3210");

                        // Create a Gson instance
                        Gson gson = new Gson();

                        // Convert the Person object to JSON string
                        String json = gson.toJson(person);
                        System.out.println("Generated JSON:");
                        System.out.println(json);

                        // Convert the JSON back to a Person object
                        Person personFromJson = gson.fromJson(json, Person.class);
                        System.out.println("\nExtracted Data from JSON:");
                        System.out.println("Name: " + personFromJson.name);
                        System.out.println("Age: " + personFromJson.age);
                        System.out.println("Is Student: " + personFromJson.isStudent);
                        System.out.println("Street: " + personFromJson.address.street);
                        System.out.println("Phone Numbers: " + personFromJson.phoneNumbers);
        }
}
