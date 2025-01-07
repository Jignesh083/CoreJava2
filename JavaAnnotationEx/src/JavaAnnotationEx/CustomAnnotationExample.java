package JavaAnnotationEx;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@interface AuthorInfo{
    String name() default "Unknown";
    String date();
}


class Book{

    @AuthorInfo(name = "Jignesh",date = "2024-12-01")
    public void printBookDetails(){
        System.out.println("This is a book about Java programming.");
    }
}


public class CustomAnnotationExample {
    public static void main(String[] args) throws Exception {
        Book book = new Book();
        book.printBookDetails();


        // Accessing the custom annotation at runtime
        AuthorInfo authorInfo = book.
                getClass().
                getMethod("printBookDetails").
                getAnnotation(AuthorInfo.class);

        System.out.println("Author: " + authorInfo.name());
        System.out.println("Date: " + authorInfo.date());
    }
}
