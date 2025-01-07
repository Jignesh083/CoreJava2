package Field.VariableEx;

import java.lang.reflect.Field;

class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

public class FieldReflectionExample{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Create an instance of Person
        Person person = new Person("John", 30);

        // Accessing public field "age" using reflection
        Field ageField = Person.class.getField("age");
        System.out.println("Age: " + ageField.get(person));  // Output: Age: 30

        // Accessing private field "name" using reflection
        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);  // Allow access to private field
        System.out.println("Name: " + nameField.get(person));  // Output: Name: John

        // Modifying the private field "name"
        nameField.set(person, "Doe");
        System.out.println("Updated Name: " + nameField.get(person));  // Output: Updated Name: Doe
    }
}

