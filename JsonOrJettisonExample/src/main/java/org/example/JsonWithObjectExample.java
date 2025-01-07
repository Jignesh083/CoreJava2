package org.example;

import com.google.gson.Gson;

public class JsonWithObjectExample {
    public static void main(String[] args) {
        System.out.println("Hello I am work with JSON");
        Student student = new Student(51,"Jignesh","Ahmedabad","93843493933");

        Gson gson = new Gson();
        String javaToJson = gson.toJson(student);
        System.out.println("Convert Java Object to JSON : ");
        System.out.println(javaToJson);
    }
}
