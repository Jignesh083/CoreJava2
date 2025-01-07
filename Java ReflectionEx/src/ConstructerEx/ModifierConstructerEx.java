package ConstructerEx;


import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class MyClass2{
    public MyClass2() {
        System.out.println("Public Constructor.");
    }


    private MyClass2(String msg){
        System.out.println("Private Constructor: "+msg);
    }
}

public class ModifierConstructerEx {
    public static void main(String[] args) {
        // Get all constructors of MyClass
        Constructor[] constructors = MyClass2.class.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            int modifiers = constructor.getModifiers();
            System.out.println("Constructor: "+ constructor.getName()+"Modifiers: "+ Modifier.toString(modifiers));
        }
    }
}
