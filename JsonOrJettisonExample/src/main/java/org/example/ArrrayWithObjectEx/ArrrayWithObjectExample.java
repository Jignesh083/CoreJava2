package org.example.ArrrayWithObjectEx;


import org.json.JSONArray;
import org.json.JSONObject;

public class ArrrayWithObjectExample {
    public static void main(String[] args) {
        JSONObject person1 = new JSONObject();
        person1.put("id", 1);
        person1.put("name", "John Doe");
        person1.put("age", 30);
        person1.put("email", "johndoe@example.com");

        JSONObject person2 = new JSONObject();
        person2.put("id", 2);
        person2.put("name", "Jane Smith");
        person2.put("age", 25);
        person2.put("email", "janesmith@example.com");

        JSONObject person3 = new JSONObject();
        person3.put("id", 3);
        person3.put("name", "Alice Johnson");
        person3.put("age", 28);
        person3.put("email", "alicejohnson@example.com");


        JSONArray jsonArray = new JSONArray();
        jsonArray.put(person1);
        jsonArray.put(person2);
        jsonArray.put(person3);

        System.out.println(jsonArray.toString(4));
    }
}
