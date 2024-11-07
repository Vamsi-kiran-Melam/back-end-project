package crud.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.model.Employee;
import crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getEmployee(long id) {
		
		return repo.findById(id).orElse(null) ;
	}

	public Employee addEmployee(Employee employee)throws IOException 
	{
		
		return repo.save(employee);
	}

	public Employee updateEmployee(long id, Employee employee) {
		
		Employee existingEmployee = repo.findById(id).orElse(null);
	    
	    if (existingEmployee != null) {
	        
	    	existingEmployee.setId(employee.getId());
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setRole(employee.getRole());
	        existingEmployee.setPlace(employee.getPlace());
	        existingEmployee.setSalary(employee.getSalary());
	        
	       
	        return repo.save(existingEmployee); 
	    } else {
	        
	        return null;
	    }
	}

	public void deleteEmployee(Long id) {
		repo.deleteById(id);
		
	}

}
