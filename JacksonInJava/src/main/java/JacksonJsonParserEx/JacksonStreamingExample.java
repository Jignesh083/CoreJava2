package JacksonJsonParserEx;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class JacksonStreamingExample {
    public static void main(String[] args) throws IOException {
        File outputFile = new File("D:\\Jignesh\\JacksonInJava\\src\\main\\data.json");

        JsonFactory jsonFactory = new JsonFactory();

        // Create JsonParser instance to read the JSON data
        JsonParser jsonParser = jsonFactory.createParser(outputFile);

        // Loop through all tokens in the JSON data
        while(!jsonParser.isClosed()){
            JsonToken token = jsonParser.nextToken();

            if(token == null){
                break;
            }


            // Print the token and its value if applicable
            switch (token) {
                case START_OBJECT:
                    System.out.println("Start of Object");
                    break;
                case END_OBJECT:
                    System.out.println("End of Object");
                    break;
                case START_ARRAY:
                    System.out.println("Start of Array");
                    break;
                case END_ARRAY:
                    System.out.println("End of Array");
                    break;
                case FIELD_NAME:
                    System.out.println("Field Name: " + jsonParser.getCurrentName());
                    break;
                case VALUE_STRING:
                    System.out.println("String Value: " + jsonParser.getText());
                    break;
                case VALUE_NUMBER_INT:
                    System.out.println("Integer Value: " + jsonParser.getIntValue());
                    break;
                case VALUE_NUMBER_FLOAT:
                    System.out.println("Float Value: " + jsonParser.getFloatValue());
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    System.out.println("Boolean Value: " + jsonParser.getBooleanValue());
                    break;
                default:
                    break;
            }
        }

        // Close the JsonParser after processing the JSON
        jsonParser.close();

    }

    }
