package JsonValueEx;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;

class Currency {
    private String code;

    public Currency(String code) {
        this.code = code;
    }

    @JsonValue // Serialize this field's value as the entire JSON value of the Currency object
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}



public class JsonValueExample {
	public static void main(String[] args) throws Exception {
        Currency currency = new Currency("USD");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(currency);
        System.out.println("Serialized JSON using @JsonValue: " + json);
    }
}
