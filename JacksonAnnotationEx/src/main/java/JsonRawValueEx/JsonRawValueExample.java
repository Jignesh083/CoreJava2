package JsonRawValueEx;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRawValueExample {

    static class Product {
        private String name;

        @JsonRawValue
        private String descriptionJson;

        public Product(String name, String descriptionJson) {
            this.name = name;
            this.descriptionJson = descriptionJson;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescriptionJson() {
            return descriptionJson;
        }

        public void setDescriptionJson(String descriptionJson) {
            this.descriptionJson = descriptionJson;
        }
    }

    public static void main(String[] args) throws Exception {
        Product product = new Product("Laptop", "{\"color\":\"red\", \"size\":\"15 inches\"}");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        System.out.println("Serialized JSON: " + json);
    }
}


//The descriptionJson field contains raw JSON data ({"color":"red", "size":"15 inches"}).
//Using @JsonRawValue, Jackson serializes it as-is without modifying it, so the value is not treated as a string but as raw JSON.
