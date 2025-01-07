package SerializationAndDeEx.GsonExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class User1{
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    public User1(String firstName,String lastName,int age,Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address=address;
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

class Address{
    private String street;
    private String city;
    private String state;
    private String zipCode;


    public Address(String street,String city,String state,String zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String toString(){
        return "Street: "+street+" City: "+city+" State: "+state+" ZipCode: "+zipCode;
    }
}
public class NestedObjectGSonEx {
    public static void main(String[] args) {
        getJson(new User1("Jignesh","Prajapati",30, new Address("xyz","Ahmedabad","Gujarat","334433")));
    }



    private static void getJson(User1 user1){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user1);
        System.out.println(json);
        getObj(json);
    }

    private static void getObj(String json){
        Gson gson = new Gson();
        User1 user1 = gson.fromJson(json, User1.class);
        System.out.println(user1);
    }
}
