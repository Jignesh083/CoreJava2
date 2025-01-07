package ReadWriteEx.GSONEx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileEx {
    public static void main(String[] args) throws IOException {
        writeFile(new User("Jignesh", "Prajapati", 45, new Address("xyz", "ahm", "guj", "4334343")));
    }


    public static void writeFile(User user) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("D:\\Jignesh\\JsonOrJettisonExample\\src\\main\\java\\Gson.json");
        gson.toJson(user, writer);
        System.out.println("Write success.");
        writer.close();
    }
}
