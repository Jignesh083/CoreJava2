package GenericExample.GenericMethodForSettingFields;

import java.lang.reflect.Field;

public class ReflectionUtility {
    // Generic method to set the value of a field
    public static<T> void setFieldValue(Object obj,String fieldName,T value) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName); // Get the field by name
        field.setAccessible(true);  //Make private fields accessible
        field.set(obj,value); // Set the value of the field
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("John",45);
        System.out.println("Before update - Name: " + person.getName() + ", Age: " + person.getAge());

        // Set the 'name' field to a new value
        setFieldValue(person,"name","Chinmay");

        // Set the 'age' field to a new value
        setFieldValue(person,"age",30);

        System.out.println("After update - Name: " + person.getName() + ", Age: " + person.getAge());
    }
}



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

    public int getAge(){
        return age;
    }
}
