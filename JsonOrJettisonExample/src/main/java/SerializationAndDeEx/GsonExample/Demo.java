package SerializationAndDeEx.GsonExample;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class User{
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

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public String getLastName(){
        return lastName;
    }


    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }


    public String toString(){
        return "FirstName: "+firstName+" LastName: "+lastName+" Age: "+age;
    }
}

public class Demo {
    public static void main(String[] args) {
        getJson(new User("Jignesh","Prajapati",22));
    }

    public static void getJson(User user){
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user); //Convert object to Json
        System.out.println(json);
        getObj(json);
    }


    public static void getObj(String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class); //Convert Json to Object
        System.out.println(user);


//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put(1,"Hello"); //Show error
    }
}
