package ReadWriteEx.JackSonEx;

import ReadWriteEx.GSONEx.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileEx {
    public static void main(String[] args) throws IOException {
        readFile("D:\\Jignesh\\JsonOrJettisonExample\\src\\main\\java\\Jackson.json");
    }


    public static void readFile(String fileAddress) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(new FileReader(fileAddress), User.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }
}
