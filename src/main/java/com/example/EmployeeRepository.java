package com.example;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {


	Map<Long, Employee> getRepository();
	List<Employee> findAll();

	Employee save(Employee e);
}
