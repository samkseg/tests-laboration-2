package com.example;
import java.util.HashMap;

public interface EmployeeRepository {

	HashMap<Long, Employee> getMap();
	Employee save(Employee e);
}
