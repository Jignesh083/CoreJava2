package JsonIdentityInfoAndJsonIdentityReferenceEx;


import java.util.ArrayList;
import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
class Department {
	private int id;
	private String name;
	private List<Employee> employees = new ArrayList<>();
 
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	// Constructor
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
 
	// Getters and setters
	public int getId() {
		return id;
	}
 
	public String getName() {
		return name;
	}
 
	public List<Employee> getEmployees() {
		return employees;
	}
 
	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setDepartment(this);
	}
}
 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
class Employee {
	private int id;
	private String name;
	   @JsonIdentityReference(alwaysAsId = true) // Serialize only the ID for the department
	private Department department;
 
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	// Constructor
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
 
	// Getters and setters
	public int getId() {
		return id;
	}
 
	public String getName() {
		return name;
	}
 
	public Department getDepartment() {
		return department;
	}
 
	public void setDepartment(Department department) {
		this.department = department;
	}
}
 
 
/*The @JsonIdentityInfo annotation in Jackson is used to handle circular references and shared objects 
* during serialization and de-serialization. It assigns a unique identifier to objects, enabling Jackson 
* to avoid infinite loops or duplicate object serialization.
* 
* The ObjectIdGenerators.PropertyGenerator is an abstract place-holder class to denote a case where Object
*  Identifier to use comes from a POJO property.
*/
 
public class JsonIdentityExample {
 
	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
 
		// Create Department and Employees
		Department dept = new Department(1, "Computer Science");
		Employee emp1 = new Employee(101, "Ram");
		Employee emp2 = new Employee(102, "Tarun");
 
		dept.addEmployee(emp1);
		dept.addEmployee(emp2);
		Department dept2 = new Department(2, "Engeeniring");
		Employee emp11 = new Employee(536, "Denish");
		Employee emp22 = new Employee(362, "Aakash");
 
		dept2.addEmployee(emp11);
		dept2.addEmployee(emp22);
 
		// Serialize the Department object
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dept);
		String json2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dept2);
 
		System.out.println("Serialized JSON:");
		System.out.println(json);
		System.out.println(json2);
 
		// Deserialize the JSON back into a Department object
		Department deserializedDept = objectMapper.readValue(json, Department.class);
 
		System.out.println("\nDeserialized Department:");
		System.out.println("Name: " + deserializedDept.getName());
		for (Employee emp : deserializedDept.getEmployees()) {
			System.out.println("- Employee: " + emp.getName() + ", Department: " + emp.getDepartment().getName());
		}
 
	}
 
}
