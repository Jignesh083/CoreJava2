package PrivateFieldsAndMethodsEx;

import java.lang.reflect.Method;

public class PersonMethod {
    private String name;

    public PersonMethod(String name){
        this.name = name;
    }


    private String getNameWithPrefix(String prefix){
        return prefix+" "+name;
    }



    // Private method
    public static void main(String[] args) throws Exception {
        // Create an instance of Person
        PersonMethod personMethod = new PersonMethod("John");

        // Accessing the private method 'getNameWithPrefix'
        Method privateMethod = PersonMethod.class.getDeclaredMethod("getNameWithPrefix", String.class);
        privateMethod.setAccessible(true);


        String result = (String) privateMethod.invoke(personMethod,"Mr.");
        System.out.println("Result: "+result);
    }
}
