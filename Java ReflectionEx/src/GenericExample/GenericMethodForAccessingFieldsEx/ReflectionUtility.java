package GenericExample.GenericMethodForAccessingFieldsEx;

import java.lang.reflect.Field;

public class ReflectionUtility {
    // Generic method to get the value of a field

    public static <T> T getFieldValue(Object obj,String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName); // Get the field by name
        field.setAccessible(true); // Make private fields accessible
        return (T) field.get(obj);  // Return the field value
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Jignesh",22);
        String name = getFieldValue(person,"name");
        int age = getFieldValue(person,"age");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }

}




class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

