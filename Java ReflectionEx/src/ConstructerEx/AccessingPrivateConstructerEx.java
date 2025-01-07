package ConstructerEx;


import java.lang.reflect.Constructor;

class MyClass1{
    private MyClass1(){
        System.out.println("Private Constructor invoked!");
    }
}

public class AccessingPrivateConstructerEx {
    public static void main(String[] args) throws Exception{
        // Get the Class object for MyClass
        Class cls = MyClass1.class;

        // Get the private constructor (no parameters)
        Constructor constructor = cls.getDeclaredConstructor();

        // Make the private constructor accessible
        constructor.setAccessible(true);

        // Create a new instance using the private constructor
        Object obj = constructor.newInstance();
    }
}
