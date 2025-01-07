package ReflactEx;

import java.lang.reflect.Constructor;

public class HowManyWaysTOCreateClassEx {
    public static void main(String[] args) throws ClassNotFoundException {
//        1. Type to Creation of Class
        Person2 p = new Person2();
        Class c = p.getClass();

//        2. type to creation of Class
//        Class c = Class.forName("ReflactEx.Person2");

//        3. Type to creation of Class
//        Class c3 = ReflactEx.Person2.class;
        Constructor[] co = c.getDeclaredConstructors();
        for (Constructor cons : co) {
            System.out.println("Constructor Name: " + cons.getName());
        }

    }
}


class Person2{
    public void person(){

    }
}

