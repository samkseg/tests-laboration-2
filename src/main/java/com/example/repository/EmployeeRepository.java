package com.example.repository;
import com.example.model.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeRepository {

	List<Employee> findAll();
	HashMap<Long, Employee> getMap();
	Employee save(Employee e);
}
