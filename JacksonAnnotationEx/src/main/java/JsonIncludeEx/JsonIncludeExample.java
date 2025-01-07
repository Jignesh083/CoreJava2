package JsonIncludeEx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

class Product {

    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null values during serialization
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}




public class JsonIncludeExample {
	public static void main(String[] args) throws Exception {
        Product product = new Product("Laptop", null);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        System.out.println("Serialized JSON: " + json);
    }
}
