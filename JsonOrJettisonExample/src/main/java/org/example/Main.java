package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person p = new Person("Jignesh", 22);
        Person p1 = new Person("Rahul", 25);

        Gson g = new Gson();
        String s = g.toJson(p);
        System.out.println(s);

        ArrayList list = new ArrayList();
        list.add(p);
        list.add(p1);

        String ans = g.toJson(list);
        System.out.println(ans);
    }
}