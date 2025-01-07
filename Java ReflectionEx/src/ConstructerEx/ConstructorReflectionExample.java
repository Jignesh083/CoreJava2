package ConstructerEx;


import java.lang.reflect.Constructor;

class MyClass{
    private int value;
    private String msg;

    public MyClass(String msg,int value){
        this.msg = msg;
        this.value = value;
    }


    public void printValues(){
        System.out.println("Messages: "+msg+" Values: "+value);
    }
}


public class ConstructorReflectionExample {
    public static void main(String[] args) throws Exception {
        // Get the Class object of MyClass
        Class cls = MyClass.class;

        // Get the constructor with two parameters (String and int)
        Constructor constructor = cls.getConstructor(String.class,int.class);

        // Create a new instance of MyClass using the constructor
        Object obj = constructor.newInstance("Hello Reflection",42);

        // Invoke the method to print values
        MyClass myObject = (MyClass) obj;
        myObject.printValues();
    }
}
