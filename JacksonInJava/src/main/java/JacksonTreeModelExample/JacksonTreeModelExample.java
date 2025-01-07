package JacksonTreeModelExample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModelExample {
    public static void main(String[] args) throws IOException {
        File jsonFile = new File("D:\\Jignesh\\JacksonInJava\\src\\main\\data.json");

        // Create ObjectMapper instance to handle JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file into a JsonNode tree
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Accessing simple values from the JSON
        String name = rootNode.path("name").asText();
        int age = rootNode.path("age").asInt();

        // Accessing nested object (address)
        JsonNode addressNode = rootNode.path("address");
        String street = addressNode.path("street").asText();
        String city = addressNode.path("city").asText();

        // Accessing array (phones)
        JsonNode phonesNode = rootNode.path("phones");
        String firstPhone = phonesNode.get(0).asText();
        String secondPhone = phonesNode.get(1).asText();

        // Print out the results
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
        System.out.println("Phone 1: " + firstPhone);
        System.out.println("Phone 2: " + secondPhone);
    }
}
