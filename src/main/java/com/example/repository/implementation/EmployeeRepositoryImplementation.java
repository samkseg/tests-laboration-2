package com.example.repository.implementation;

import com.example.repository.EmployeeRepository;
import com.example.model.Employee;

import java.util.HashMap;
import java.util.List;

public class EmployeeRepositoryImplementation implements EmployeeRepository {

    HashMap<Long, Employee> repository = new HashMap<>();

    public EmployeeRepositoryImplementation(List<Employee> employees) {
        for (Employee employee: employees) {
            repository.put(employee.getId(), employee);
        }
    }

    @Override
    public List<Employee> findAll() {
        return repository.values().stream().toList();
    }

    @Override
    public HashMap<Long, Employee> getMap() {
        return repository;
    }

    @Override
    public Employee save(Employee e) {
        repository.put(e.getId(), e);
        return repository.get(e.getId());
    }
}
