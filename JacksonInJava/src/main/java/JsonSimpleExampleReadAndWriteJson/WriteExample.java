package JsonSimpleExampleReadAndWriteJson;


import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Rahul");
        jsonObject.put("age",43);
        jsonObject.put("city","New York");

        try(FileWriter file = new FileWriter("D:\\Jignesh\\JacksonInJava\\src\\main\\java\\JsonSimpleExampleReadAndWriteJson\\output.json")){
            // Write the JSON object to file
            file.write(jsonObject.toString(4));
            System.out.println("Successfully written JSON to file.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
