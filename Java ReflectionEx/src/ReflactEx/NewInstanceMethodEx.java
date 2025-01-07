package ReflactEx;

public class NewInstanceMethodEx {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("ReflactEx.Person4");
            Person4 p = (Person4) c.newInstance(); //get new object
            p.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Person4{
    public void show(){
        System.out.println("Show");
    }
}
