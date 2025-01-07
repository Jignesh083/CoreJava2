package JsonFormatEx;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Event{
	private String name;
	
	@JsonFormat(pattern = "yyyy-dd-mm")
	private Date eventDate;
	
	@JsonCreator
//	Event(){
//		 
//	}
	public Event(@JsonProperty("name") String name, @JsonProperty("date") Date date) {
		this.setName(name);
		this.eventDate=date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getEventDate()
	{
		return eventDate;
	}
	
	public void setEventDate(Date date) {
		this.eventDate = date;
	}
}

public class JsonFormatExample {
	public static void main(String[] args) throws JsonProcessingException {
        // Create an Event object with a specific date
		Event event = new Event("Music",new Date());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Serialize the event object to JSON
		String json = objectMapper.writeValueAsString(event);
        System.out.println("Serialized JSON: " + json);
        
        
        
        // Deserialize the JSON back to Event object
        Event deSerialized = objectMapper.readValue(json,Event.class);
        System.out.println("Deserialized Event Date: " + deSerialized.getEventDate());

	}
}
