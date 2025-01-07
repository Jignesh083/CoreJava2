package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;


class Student {
    int rollNo;
    String name;
    String city;
    String phoneNo;


    public Student(int rollNo, String name, String city, String phoneNo) {
        this.rollNo = rollNo;
        this.name = name;
        this.city = city;
        this.phoneNo = phoneNo;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public JSONObject toJson() {
        // Convert the custom object to a JSON object
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("RollNo", rollNo);
        jsonobject.put("Name", name);
        jsonobject.put("City", city);
        jsonobject.put("PhoneNo", phoneNo);

        return jsonobject;
    }
}



public class ArrayWithObjectExample {
    public static void main(String[] args) {

        Student[] student= new Student[5];
        student[0] = new Student(55, "Deepak", "Dholka", "33848248262");
        student[1] = new Student(51, "Rahul", "Diu", "7634367363");
        student[2] = new Student(44, "Prashant", "Mahesana", "872384843");
        student[3] = new Student(53, "Jignesh", "Surat", "90992849238");
        student[4] = new Student(33, "Chinmay", "Somnath", "898983292223");

        // Convert the custom objects to JSON and store them in a JSONArray

        JSONArray jsonarr= new JSONArray();
        for(Student students: student) {
            jsonarr.put(students.toJson());
        }
        System.out.println(jsonarr.toString(10)); // Pretty print with indentation

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Second Way By Using Gjon.");

        // Create a Gson instance
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the array of custom objects to JSON
        String jsonArray = gson.toJson(student);

        // Print the JSON array
        System.out.println(jsonArray);
    }

}

