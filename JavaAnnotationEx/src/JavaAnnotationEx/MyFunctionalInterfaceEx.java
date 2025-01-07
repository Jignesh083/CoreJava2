package JavaAnnotationEx;

@FunctionalInterface
interface MyFunctionalInterface{
    void myMethod();
}

public class MyFunctionalInterfaceEx {
    public static void main(String[] args) {
        MyFunctionalInterface obj = () -> System.out.println("Functional Interface");
        obj.myMethod();
    }
}
