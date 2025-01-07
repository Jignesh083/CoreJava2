package SerializationAndDeEx.GsonExample.JacksonInJava;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class User{

    User(){

    }
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName,String lastName,int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }


    public int getAge(){
        return age;
    }

    public String toString(){
        return "FirstName: "+firstName+" LastName: "+lastName+" Age: "+age;
    }
}
public class JacksonDemoEx {
    public static void main(String[] args) throws IOException {
        getJson(new User("Jignesh","Prajapati",22));
    }

    public static void getJson(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(json);
        getObj(json);
    }

    public static void getObj(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
    }
}
