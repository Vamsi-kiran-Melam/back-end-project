package crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.model.Employee;
import crud.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empservice;
	
	
	@GetMapping("/")
	public ResponseEntity <List<Employee>> getAllEmployees(){
		
		return new ResponseEntity<> (empservice.getAllEmployees(), HttpStatus.OK);
		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity <Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = empservice.getEmployee(id);
		if(employee!=null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		try {
		Employee employee1 = empservice.addEmployee(employee);
		return new ResponseEntity<>(employee1, HttpStatus.CREATED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		Employee employee2 = empservice.updateEmployee(id, employee);
		if(employee2!=null) {
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		
		Employee employee3 = empservice.getEmployee(id);
		if(employee3!=null) {
			empservice.deleteEmployee(id);
			return new ResponseEntity<>("one employee delete succefully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("employee not found", HttpStatus.NOT_FOUND);
		}
		
	}

}
