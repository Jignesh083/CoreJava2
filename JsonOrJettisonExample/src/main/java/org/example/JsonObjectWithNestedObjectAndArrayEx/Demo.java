package org.example.JsonObjectWithNestedObjectAndArrayEx;

import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {
    public static void main(String[] args) {
            // Create the nested JSON object for the address
            JSONObject address = new JSONObject();
            address.put("street", "123 Main St");
            address.put("city", "New York");
            address.put("state", "NY");
            address.put("zipcode", "10001");

            // Create the JSON array for phone numbers
            JSONArray phoneNumbers = new JSONArray();

            // Create the phone number objects and add them to the array
            JSONObject homePhone = new JSONObject();
            homePhone.put("type", "home");
            homePhone.put("number", "555-1234");
            phoneNumbers.put(homePhone);

            JSONObject mobilePhone = new JSONObject();
            mobilePhone.put("type", "mobile");
            mobilePhone.put("number", "555-5678");
            phoneNumbers.put(mobilePhone);

            // Create the main JSON object for the person
            JSONObject person = new JSONObject();
            person.put("id", 1);
            person.put("name", "John Doe");
            person.put("age", 30);
            person.put("email", "johndoe@example.com");

            // Add the nested address object to the main person object
            person.put("address", address);

            // Add the nested phone numbers array to the main person object
            person.put("phoneNumbers", phoneNumbers);

            // Print the JSON object with the nested object and array
            System.out.println(person.toString(4));  // Pretty print with indentation

    }
}
