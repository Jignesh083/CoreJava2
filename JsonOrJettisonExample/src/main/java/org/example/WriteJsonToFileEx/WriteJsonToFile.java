package org.example.WriteJsonToFileEx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteJsonToFile {
        public static void main(String[] args) {
            // Create a nested JSON object for the address
            JSONObject address = new JSONObject();
            address.put("street", "123 Main St");
            address.put("city", "New York");
            address.put("state", "NY");
            address.put("zipcode", "10001");

            // Create an array of courses
            JSONArray courses = new JSONArray();

            // Add courses to the array
            JSONObject course1 = new JSONObject();
            course1.put("courseId", "CS101");
            course1.put("courseName", "Computer Science 101");
            course1.put("credits", 3);
            courses.put(course1);

            JSONObject course2 = new JSONObject();
            course2.put("courseId", "MATH202");
            course2.put("courseName", "Calculus II");
            course2.put("credits", 4);
            courses.put(course2);

            // Create a Student object (JSON)
            JSONObject student = new JSONObject();
            student.put("id", 1);
            student.put("name", "John Doe");
            student.put("age", 21);
            student.put("email", "johndoe@example.com");
            student.put("address", address);
            student.put("courses", courses);
            student.put("isActive", true);

            // Specify the file where the JSON data will be written
            File file = new File("student.json");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the JSON object to the file as a pretty-printed string
                writer.write(student.toString(4));  // Pretty print with indentation of 4 spaces
                System.out.println("JSON data has been written to the file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
