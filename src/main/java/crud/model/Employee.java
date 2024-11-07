package crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "salary")
	private double salary;
	
	
	public Employee(long id, String name,String role, String place, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.place = place;
		this.salary = salary;
	}
	
	public  Employee() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "BasicCrudSystem [id=" + id + ", name=" + name + ",role=" + role + ", place=" + place + ", salary=" + salary + "]";
	}
	
	
	

}
