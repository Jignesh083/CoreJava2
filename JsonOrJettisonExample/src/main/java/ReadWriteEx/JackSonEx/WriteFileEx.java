package ReadWriteEx.JackSonEx;

import ReadWriteEx.GSONEx.Address;
import ReadWriteEx.GSONEx.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileEx {
    public static void main(String[] args) throws IOException {
        writeFile(new User("Rahul","Sosa",24,new Address("xyz","Ahm","guj","343433")));
    }


    public static void writeFile(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter fileWriter = new FileWriter("D:\\Jignesh\\JsonOrJettisonExample\\src\\main\\java\\Jackson.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter,user);
        fileWriter.close();
        System.out.println("Write Successfull.");

    }
}
