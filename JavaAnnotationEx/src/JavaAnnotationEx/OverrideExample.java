package JavaAnnotationEx;

class Animal{
    public void sound(){
        System.out.println("Animal make a sound.");
    }
}




class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Dog barking.");
    }
}



public class OverrideExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
    }
}
