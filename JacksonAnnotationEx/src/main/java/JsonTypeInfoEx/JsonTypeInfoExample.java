package JsonTypeInfoEx;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
abstract class Animal {
    public abstract String sound();
}

class Dog extends Animal {
    @Override
    public String sound() {
        return "Bark";
    }
}

class Cat extends Animal {
    @Override
    public String sound() {
        return "Meow";
    }
}



public class JsonTypeInfoExample {
	public static void main(String[] args) throws Exception {
        Animal dog = new Dog();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dog);
        System.out.println("Serialized JSON: " + json);
    }
}
