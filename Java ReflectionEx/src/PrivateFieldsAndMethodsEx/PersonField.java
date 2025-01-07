package PrivateFieldsAndMethodsEx;

import java.lang.reflect.Field;

public class PersonField {
    private String name;
    private int age;

    public PersonField(String name, int age){
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) throws Exception {
        PersonField person = new PersonField("jignesh",22);

        // Accessing the private field 'name'
        Field nameField = PersonField.class.getDeclaredField("name");
        nameField.setAccessible(true); // Allow access to the private field


        // Get the value of the private field 'name'
        String name = (String) nameField.get(person);
        System.out.println("Name: "+name);


        // Accessing and modifying the private field 'age'
        Field ageField = PersonField.class.getDeclaredField("age");
        ageField.setAccessible(true); // Allow access to the private field
        ageField.set(person, 35); // Set the new value for 'age'


        // Get the modified value of 'age'
        int age = (int) ageField.get(person);
        System.out.println("Age: " + age);

    }
}
