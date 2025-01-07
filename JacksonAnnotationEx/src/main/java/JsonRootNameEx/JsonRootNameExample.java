package JsonRootNameEx;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonRootName("productDetails")  // Specify the root element name in the serialized JSON
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



public class JsonRootNameExample {
	 public static void main(String[] args) throws Exception {
	        Product product = new Product("Laptop", 999.99);

	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE); // Enable root wrapping
	        String json = objectMapper.writeValueAsString(product);
	        System.out.println("Serialized JSON with Root Name: " + json);
	    }
}


//The @JsonRootName("productDetails") annotation on the Product class changes the root element name in the serialized JSON to "productDetails".
//The objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE) enables root wrapping, so the serialized JSON will have the custom root element (productDetails).



//The @JsonRootName("productDetails") annotation on the Product class changes the root element name in the serialized JSON to "productDetails".
//The objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE) enables root wrapping, so the serialized JSON will have the custom root element (productDetails).

//Both annotations provide powerful tools for fine-tuning how your Java objects are serialized into JSON in Jackson.