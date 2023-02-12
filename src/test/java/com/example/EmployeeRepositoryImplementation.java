package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImplementation implements EmployeeRepository {

    HashMap<Long, Employee> repository = new HashMap<>();

    public EmployeeRepositoryImplementation(List<Employee> employees) {
        for (Employee employee: employees) {
            repository.put(employee.getId(), employee);
        }
    }

    @Override
    public Map<Long, Employee> getRepository() {
        return repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.values().stream().toList();
    }

    @Override
    public Employee save(Employee e) {
        repository.put(e.getId(), e);
        return repository.get(e.getId());
    }
}
