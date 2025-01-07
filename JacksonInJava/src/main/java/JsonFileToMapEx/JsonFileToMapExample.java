package JsonFileToMapEx;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonFileToMapExample {
    public static void main(String[] args) throws IOException {
        File jsonFile = new File("D:\\Jignesh\\JacksonInJava\\src\\main\\data.json");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(jsonFile, Map.class);
        System.out.println(map);
    }
}
