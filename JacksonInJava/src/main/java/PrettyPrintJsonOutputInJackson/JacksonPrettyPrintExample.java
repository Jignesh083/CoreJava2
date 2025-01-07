package PrettyPrintJsonOutputInJackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonPrettyPrintExample {
            public static void main(String[] args) {
                // Example data (you could use a POJO or a Map)
                Person person = new Person("Alice", 30, "Wonderland");

                // Create ObjectMapper instance
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    // Pretty print JSON string
                    String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

                    // Print the pretty JSON
                    System.out.println(prettyJson);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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

            // Getters and Setters
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
