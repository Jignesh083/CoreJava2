package AnnotationPlacementEx;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String description() default "No description provided";
}



@MyAnnotation(description = "This is a class-level annotation")
public class MyClass {
    // Apply annotation to a field
    @MyAnnotation(description = "This is a field-level annotation")
    private String name;

    // Constructor with a parameter-level annotation
    public MyClass(@MyAnnotation(description = "This is a parameter-level annotation") String name){
        this.name = name;
    }


    // Apply annotation to a method
    @MyAnnotation(description = "This is a method-level annotation")
    public void display(){
        System.out.println("Name: "+name);
    }


    public static void main(String[] args) {
        // Create an object of MyClass
        MyClass myClass = new MyClass("Jignesh");

        // Call the display method
        myClass.display();


        // Using reflection to print annotation details
        try{
            // Class annotations
            if (MyClass.class.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation classAnnotation = MyClass.class.getAnnotation(MyAnnotation.class);
                System.out.println("Class Annotation: " + classAnnotation.description());
            }


            // Method annotations
            if (myClass.getClass().getMethod("display").isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation methodAnnotation = myClass.getClass().getMethod("display").getAnnotation(MyAnnotation.class);
                System.out.println("Method Annotation: " + methodAnnotation.description());
            }


            // Field annotations
            if (MyClass.class.getDeclaredField("name").isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation fieldAnnotation = MyClass.class.getDeclaredField("name").getAnnotation(MyAnnotation.class);
                System.out.println("Field Annotation: " + fieldAnnotation.description());
            }


            // Parameter annotations
            if (MyClass.class.getConstructor(String.class).getParameters()[0].isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation paramAnnotation = MyClass.class.getConstructor(String.class).getParameters()[0].getAnnotation(MyAnnotation.class);
                System.out.println("Parameter Annotation: " + paramAnnotation.description());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
