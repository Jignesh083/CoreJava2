package SerializationAndDeEx.GsonExample.JacksonInJava;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Address{
    private String Street;
    private String city;
    private String state;
    private String zipcode;

    Address(){

    }

    Address(String street, String city, String state, String zipcode) {
        this.Street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String toString(){
        return "Street: "+Street+" City: "+city+" State: "+state+" ZipCode: "+zipcode;
    }
}


class User1{
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    User1(){

    }
    User1(String firstName, String lastName, int age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String toString(){
        return "FirstName: "+firstName+" LastName: "+lastName+" Age: "+age+" Address: "+address;
    }
}
public class NestedObjectEx {
    public static void main(String[] args) throws JsonProcessingException {
        getJson(new User1("Jignesh","Prajapati",24,new Address("xyz","Ahm","Guj","44544")));
    }

    private static void getJson(User1 user1) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user1);
        System.out.println(json);
        getObj(json);
    }


    private static void getObj(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User1 user = objectMapper.readValue(json, User1.class);
        System.out.println(user);
    }
}
