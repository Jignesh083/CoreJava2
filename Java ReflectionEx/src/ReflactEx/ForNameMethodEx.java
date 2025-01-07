package ReflactEx;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Person1{
    public void show(){

    }
    private int display(){
        return 0;
    }
}


public class ForNameMethodEx {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("ReflactEx.Person1");
            Method[] methods = c.getDeclaredMethods();
            for(Method m:methods){
                System.out.println("Method Name: " + m.getName());
                int s = m.getModifiers();
                System.out.println("AccessModifiers Name: " + Modifier.toString(s));
                System.out.println("Return type Name: "+m.getReturnType());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
