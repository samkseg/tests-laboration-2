package com.example;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {


	Map<Long, Employee> getRepository();
	Employee save(Employee e);
}
