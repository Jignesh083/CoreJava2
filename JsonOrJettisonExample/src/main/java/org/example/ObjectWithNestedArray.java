package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Employee{
    private String name;
    private int salary;

    String[] friends;

    public Employee(String name,int salary,String[] friends){
        this.name = name;
        this.salary = salary;
        this.friends = friends;
    }
}
public class ObjectWithNestedArray {
    public static void main(String[] args) {
        String[] friend = {"Keyur","Rahul","Sosa","Chinmay","Jignesh"};

        Employee emp = new Employee("Abhinav",50000,friend);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(emp);
        System.out.println(json);
    }
}
