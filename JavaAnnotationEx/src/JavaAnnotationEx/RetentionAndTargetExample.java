package JavaAnnotationEx;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyCustomAnnotation{
    String value() default "Custom Annotation";
}


class MyClass{
    @MyCustomAnnotation(value = "This is a Custom Annotation")
    public void myMethod(){
        System.out.println("Method with custom annotation");
    }
}


public class RetentionAndTargetExample {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        myClass.myMethod();


        // Accessing the custom annotation at runtime
        MyCustomAnnotation annotation = myClass.getClass().getMethod("myMethod").getAnnotation(MyCustomAnnotation.class);
        System.out.println("Annotation value: " + annotation.value());
    }
}
