package GettersAndSettersEx;

import java.lang.reflect.Method;

public class Person {
    private String name;
    private int age;

    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }



    public void setAge(int age){
        this.age = age;
    }


    public static void main(String[] args) throws Exception {
        // Create an instance of Person
        Person person = new Person();

        // Use reflection to access and invoke the getter and setter methods

        // Accessing the 'setName' method
        Method setNameMethod = Person.class.getMethod("setName", String.class);
        setNameMethod.invoke(person,"Jignesh");

        // Accessing the 'getName' method
        Method getNameMethod = Person.class.getMethod("getName");
        String name = (String) getNameMethod.invoke(person);
        System.out.println("Name: "+name);


        // Accessing the 'setAge' method
        Method setAgeMethod  =Person.class.getMethod("setAge", int.class);
        setAgeMethod.invoke(person,30);

        // Accessing the 'getAge' method
        Method getAgeMethod = Person.class.getMethod("getAge");
        int age = (int) getAgeMethod.invoke(person);
        System.out.println("Age: "+age);
    }
}
