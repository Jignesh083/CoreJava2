package JsonSubTypeEx;



import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import java.io.IOException;
 
// Parent class
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,  // Use the type name as the identifier
    include = JsonTypeInfo.As.PROPERTY,  // Use the 'type' property for type info
    property = "type"  // The field holding the type information
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Dog.class, name = "dog"),  // Dog is identified by "dog"
    @JsonSubTypes.Type(value = Cat.class, name = "cat")   // Cat is identified by "cat"
})
abstract class Animal {
    // No need to manually set the type here, Jackson will manage it
    // Remove the `type` field declaration if you want Jackson to handle it automatically.
    // public String type;  
 
    // Default constructor for Jackson deserialization
    public Animal() {
        // No-argument constructor required for Jackson deserialization
    }
}
 
// Child Class 1
@JsonTypeName("dog")  // Specify the type name for the subclass
class Dog extends Animal {
    public String breed;  // Additional property for Dog
 
    // Default constructor
    public Dog() {
        // No-argument constructor for deserialization
    }
 
    // Constructor with breed
    public Dog(String breed) {
        this.breed = breed;
    }
}
 
// Child Class 2
@JsonTypeName("cat")  // Specify the type name for the subclass
class Cat extends Animal {
    public String color;  // Additional property for Cat
 
    // Default constructor
    public Cat() {
        // No-argument constructor for deserialization
    }
 
    // Constructor with color
    public Cat(String color) {
        this.color = color;
    }
}
 
public class JsonSubTypeExample{
    public static void main(String[] args) throws IOException {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();
 
        // Create Dog and Cat objects
        Dog dog = new Dog("Labrador");
        // Do not manually set type field for dog or cat
 
        Cat cat = new Cat("White");
        // Do not manually set type field for cat
 
        // Serialize the list of animals to JSON
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Animal[] {dog, cat});
        System.out.println("Serialized JSON:");
        System.out.println(json);
 
        // Deserialize the JSON back into the list of animals (polymorphic list)
        Animal[] deserializedAnimals = mapper.readValue(json, Animal[].class);
 
        // Print the deserialized objects
        System.out.println("\nDeserialized Objects:");
        for (Animal animal : deserializedAnimals) {
            System.out.println("Animal Type: " + animal.getClass().getSimpleName()); // Getting the class name of the object
            if (animal instanceof Dog) {
                System.out.println("Breed: " + ((Dog) animal).breed);
            } else if (animal instanceof Cat) {
                System.out.println("Color: " + ((Cat) animal).color);
            }
        }
    }
}



//This tells Jackson to include type information in the JSON

//Annotation used with JsonTypeInfo to indicate sub-types of serializable polymorphic types, and to associate logical names used within JSON content (which is more portable than using physical Java class names).
