package org.example.JsonObjectWithNestedObjectEx;

import org.json.JSONObject;

public class Demo {
    public static void main(String[] args) {
        // Create the nested JSON object for the address
        JSONObject address = new JSONObject();
        address.put("street", "123 Main St");
        address.put("city", "New York");
        address.put("state", "NY");
        address.put("zipcode", "10001");

        // Create the main JSON object for the person
        JSONObject person = new JSONObject();
        person.put("id", 1);
        person.put("name", "John Doe");
        person.put("age", 30);
        person.put("email", "johndoe@example.com");

        // Add the nested address object to the person object
        person.put("address", address);

        // Print the JSON object with the nested object
        System.out.println(person.toString(4));  // Pretty print with indentation
    }
}
