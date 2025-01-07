package MapToJsonString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonExample {
    public static void main(String[] args) throws JsonProcessingException {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Jignesh");
        map.put("age",30);
        map.put("city","NewYork");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(map);
        System.out.println(jsonString);
    }
}
