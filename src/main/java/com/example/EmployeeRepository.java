package com.example;
import java.util.Map;

public interface EmployeeRepository {

	Map<Long, Employee> getMap();
	Employee save(Employee e);
}
