package JacksonJsonGeneratorEx;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;

public class JacksonStreamingExample {
    public static void main(String[] args) throws IOException {
        // File to output the JSON
        File outputFile  = new File("D:\\Jignesh\\JacksonInJava\\src\\main\\data.json");

        // Create a JsonFactory instance
        JsonFactory jsonFactory = new JsonFactory();

        // Create a JsonGenerator instance to write JSON data
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(outputFile, com.fasterxml.jackson.core.JsonEncoding.UTF8);

        // Start writing the JSON structure
        jsonGenerator.writeStartObject();

        // Write key-value pairs
        jsonGenerator.writeStringField("name","Jignesh");
        jsonGenerator.writeNumberField("age",30);
        jsonGenerator.writeStringField("city","wonderland");

        // Start nested object (address)
        jsonGenerator.writeFieldName("address");
        jsonGenerator.writeStartObject();


        // Write key-value pairs inside the nested object
        jsonGenerator.writeStringField("street", "123 Main St");
        jsonGenerator.writeStringField("zip", "12345");

        // End nested object
        jsonGenerator.writeEndObject();

        // Start an array (phones)
        jsonGenerator.writeFieldName("phones");
        jsonGenerator.writeStartArray();  // Start of the array

        // Write array elements
        jsonGenerator.writeString("123-456-7890");
        jsonGenerator.writeString("987-654-3210");

        // End array
        jsonGenerator.writeEndArray();

        // End the main object
        jsonGenerator.writeEndObject();

        // Close the JsonGenerator to finish writing the JSON
        jsonGenerator.close();

        System.out.println("JSON written to file: " + outputFile.getAbsolutePath());

    }
}
