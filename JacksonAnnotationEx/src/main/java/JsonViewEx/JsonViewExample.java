package JsonViewEx;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

class Views {
    public static class Public {}
    public static class Admin extends Public {}
}

class User {
    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Admin.class)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class JsonViewExample {
    public static void main(String[] args) throws Exception {
        User user = new User("John Doe", "john@example.com");

        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize with Public View
        String publicJson = objectMapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);
        System.out.println("Public View JSON: " + publicJson);

        // Serialize with Admin View
        String adminJson = objectMapper
                .writerWithView(Views.Admin.class)
                .writeValueAsString(user);
        System.out.println("Admin View JSON: " + adminJson);
    }
}

