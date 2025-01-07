package org.example.ObjectWithNestedArrayEx;

import org.json.JSONArray;
import org.json.JSONObject;

public class Example {
    public static void main(String[] args) {
        // Creating individual JSON objects for friends
        JSONObject friend1 = new JSONObject();
        friend1.put("id", 2);
        friend1.put("name", "Alice");
        friend1.put("age", 29);

        JSONObject friend2 = new JSONObject();
        friend2.put("id", 3);
        friend2.put("name", "Bob");
        friend2.put("age", 31);

        // Creating a JSON array and adding the friend objects to it
        JSONArray friendsArray = new JSONArray();
        friendsArray.put(friend1);
        friendsArray.put(friend2);

        // Creating the main JSON object
        JSONObject person = new JSONObject();
        person.put("id", 1);
        person.put("name", "John Doe");
        person.put("age", 30);
        person.put("email", "johndoe@example.com");

        // Adding the nested array (friends) to the main object
        person.put("friends", friendsArray);

        // Printing the JSON object with a nested array
        System.out.println(person.toString(4));  // Pretty print with indentation
    }
}
