package ClassesEx;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

class Example{
    private String msg;

    public Example(String msg){
        this.msg = msg;
    }

    private void printMsg(){
        System.out.println("Message: "+msg);
    }
}


public class ReflectionEx {
    public static void main(String[] args) throws Exception{
        // Get the Class object for the Example class
        Class cls = Class.forName("ClassesEx.Example");

        // Get the constructor and create an instance of Example
        Constructor constructor = cls.getDeclaredConstructor(String.class);
        Object exampleObj = constructor.newInstance("Hello Reflection.");

        // Get the private method and invoke it
        Method method = cls.getDeclaredMethod("printMsg");
        method.setAccessible(true);
        method.invoke(exampleObj);
    }
}
