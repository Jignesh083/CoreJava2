package IntroductionToJavaReflectionEx;

import java.io.FilterOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    private String msg = "Hello from Reflection!";
    public void printMessage(){
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        // Get the class object
        Class cls = ReflectionExample.class;

        // Create an instance of the class dynamically
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Access private field
        Field field = cls.getDeclaredField("msg");
        field.setAccessible(true);  // Allows access to private field
        System.out.println("Private field(Variable) value: "+field.get(obj));


        // Access method and invoke it
        Method method = cls.getDeclaredMethod("printMessage");
        method.setAccessible(true); // Allows access to private methods
        method.invoke(obj);
    }
}
