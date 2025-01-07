package GenericExample.GenericMethodToInvokeMethodsEx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtility {
    // Generic method to invoke a method by name
    public static <T> T invokeMethod(Object obj,String methodName,Class<?>[] paramTypes,Object[] param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes); // Get the method by name
        method.setAccessible(true); //Make private methods accessible
        return (T) method.invoke(obj,param); // Invoke the method and return the result
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Person person = new Person("Roman", 55);

        // Invoke the private method 'getNameWithPrefix' using reflection
        Class<?>[] paramTypes = {String.class};
        Object[] param = {"Mr."};

        String result = invokeMethod(person, "getNameWithPrefix", paramTypes, param);
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

    private String getNameWithPrefix(String prefix){
        return prefix+" "+name;
    }
}
