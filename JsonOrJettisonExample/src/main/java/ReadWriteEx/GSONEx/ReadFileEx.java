package ReadWriteEx.GSONEx;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadFileEx {
    public static void main(String[] args) throws IOException {

       readFile("D:\\Jignesh\\JsonOrJettisonExample\\src\\main\\java\\Gson.json");


    }
        private static void readFile (String fileAddress) throws FileNotFoundException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            User users = gson.fromJson(new FileReader(fileAddress), User.class);
            System.out.println(gson.toJson(users));
        }
}
