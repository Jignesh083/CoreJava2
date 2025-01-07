package JavaAnnotationEx;


import java.util.ArrayList;

public class SuppressWarningsExample {
        @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Unchecked warning
        list.add("Hello");
        list.add("World");

        System.out.println(list);

    }
}
