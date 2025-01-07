package JsonStringToMapEx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonToMapExample {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = """
                {
                "name": "Jignesh",
                "age": 20,
                "city": "ahm" 
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(jsonString, Map.class);
        System.out.println(map);


    }
}
