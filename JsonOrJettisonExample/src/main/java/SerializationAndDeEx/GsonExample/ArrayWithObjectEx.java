package SerializationAndDeEx.GsonExample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

class Person{
    private String name;
    private int age;


    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }


    public String getName(){
        return name;
    }


    public int getAge(){
        return age;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

//
//    public String toString(){
//        return "Name: "+name +" Age: "+age;
//    }

}

public class ArrayWithObjectEx {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("John", 30),
                new Person("Alice", 25),
                new Person("Bob", 35)
        );

        Gson gson = new Gson();

        String json = gson.toJson(personList);

        System.out.println("Serialized: " + json);


//        In Java, due to type erasure, you cannot directly pass List<Person>.class because generics are erased at runtime. But using TypeToken, Gson can get the generic type at runtime.
        Type personListType = new TypeToken<List<Person>>() {}.getType();
        List<Person> deSerialized = gson.fromJson(json,personListType);

        System.out.println("Deserialized List:");
        for (Person person : deSerialized) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}
