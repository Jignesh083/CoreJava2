package JavaAnnotationEx;


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyInheritedAnnotation {}

@MyInheritedAnnotation
class SuperClass {}

class SubClass extends SuperClass {}


public class MyInheritedAnnotationEx {
    public static void main(String[] args) {
        System.out.println(SubClass.class.isAnnotationPresent(MyInheritedAnnotation.class));
    }
}
