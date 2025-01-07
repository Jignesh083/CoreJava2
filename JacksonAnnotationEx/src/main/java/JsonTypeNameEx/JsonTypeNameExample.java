package JsonTypeNameEx;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTypeName("dog")
class Dog extends Animal {
    private String breed;

    public Dog() {
		super();
	}

	public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Woof";
    }
}

@JsonTypeName("cat")
class Cat extends Animal {
    private String color;
    
    Cat(){
    	super();
    }

    public Cat(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String makeSound() {
        return "Meow";
    }
}



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class Animal {
    public abstract String makeSound();
    
}



public class JsonTypeNameExample {
	public static void main(String[] args) throws Exception {
		// Create instances of Dog and Cat
        Animal dog = new Dog("Golden Retriever");
        Animal cat = new Cat("Black");

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize Dog and Cat objects to JSON
        String dogJson = objectMapper.writeValueAsString(dog);
        String catJson = objectMapper.writeValueAsString(cat);

        System.out.println("Dog JSON: " + dogJson);
        System.out.println("Cat JSON: " + catJson);

    }
}
