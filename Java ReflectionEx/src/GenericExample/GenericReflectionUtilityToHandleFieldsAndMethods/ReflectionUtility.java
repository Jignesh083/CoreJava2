package GenericExample.GenericReflectionUtilityToHandleFieldsAndMethods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtility {

    // Generic method to get a field value
    public static<T> T getFieldValue(Object obj,String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return(T) field.get(obj);
    }


    // Generic method to set a field value
    public static<T> void setFieldValue(Object obj,String fieldName,T value) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj,value);
    }



    // Generic method to invoke a method
    public static <T> T invokeMethod(Object obj,String methodName,Class<?>[] paramTypes,Object[] params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes);
        method.setAccessible(true);
        return (T) method.invoke(obj, params);
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Person person = new Person("Aalap",22);
        System.out.println("Before update - Name: " + person.getName() + ", Age: " + person.getAge());

        // Set fields dynamically
        setFieldValue(person,"name","Rahul");
        setFieldValue(person,"age",25);


        System.out.println("After update - Name: " + person.getName() + ", Age: " + person.getAge());

        // Invoke method dynamically
        Class<?>[] paramTypes = {String.class};
        Object[] params = {"Mr."};
        String result = invokeMethod(person, "getNameWithPrefix", paramTypes, params);
        System.out.println("Result from invoked method: " + result);


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


    private String getNameWithPrefix(String prefix){
        return prefix+" "+name;
    }
}