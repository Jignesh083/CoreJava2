package org.example.StudentEx;

import org.json.JSONArray;
import org.json.JSONObject;

public class Student {
        private int id;
        private String name;
        private int age;
        private String email;
        private JSONObject address;
        private JSONArray courses;
        private boolean isActive;

        // Constructor
        public Student(int id, String name, int age, String email, JSONObject address, JSONArray courses, boolean isActive) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.address = address;
            this.courses = courses;
            this.isActive = isActive;
        }

        // Method to convert Student to JSON format
        public JSONObject toJSON(){
            JSONObject studentJSON = new JSONObject();
            studentJSON.put("id", this.id);
            studentJSON.put("name", this.name);
            studentJSON.put("age", this.age);
            studentJSON.put("email", this.email);
            studentJSON.put("address", this.address);
            studentJSON.put("courses", this.courses);
            studentJSON.put("isActive", this.isActive);
            return studentJSON;
        }

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

            // Create a Student object
            Student student = new Student(1, "John Doe", 21, "johndoe@example.com", address, courses, true);

            // Convert Student object to JSON
            JSONObject studentJSON = student.toJSON();

            // Print the student JSON object
            System.out.println(studentJSON.toString(4)); // Pretty print with indentation
        }
}
