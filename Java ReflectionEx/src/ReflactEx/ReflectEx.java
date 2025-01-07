package ReflactEx;

import java.lang.reflect.Method;

class Parent{

}

class Person extends Parent{
    public void show(){

    }
}


public class ReflectEx {
    public static void main(String[] args) {
        Person p = new Person();
        Class c = p.getClass();
        String name = c.getName();
        System.out.println(name);
        Method[] methods = c.getDeclaredMethods();
        for (Method m:methods){
            System.out.println(m.getName());
        }

        Class superClass = c.getSuperclass();
        System.out.println("SuperClass: "+superClass.getName());
    }
}
