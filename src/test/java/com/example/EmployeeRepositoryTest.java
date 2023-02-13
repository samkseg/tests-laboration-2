package com.example;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRepositoryTest {

    private List<Employee> mockingRepository = List.of(
            new Employee(1, 10000),
            new Employee(2, 10000),
            new Employee(3, 10000),
            new Employee(4, 10000),
            new Employee(5, 10000)
    );
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImplementation(mockingRepository);

    @Order(1)
    @Test
    public void shouldReturnMapOfEmployees() {
        HashMap<Long, Employee> employeeMap = new HashMap<>();
        for (Employee employee : mockingRepository) {
            employeeMap.put(employee.getId(), employee);
        }
        assertEquals(employeeMap, employeeRepository.getMap());
    }

    @Order(2)
    @Test
    public void shouldReturnListOfEmployees(){
        assertEquals(mockingRepository, employeeRepository.findAll());
    }

    @Order(3)
    @Test
    public void shouldSaveNewEmployee() {
        Employee employee = new Employee(6, 10000);
        employeeRepository.save(employee);

        assertEquals(6, employeeRepository.getMap().size());
    }
    @Order(4)
    @Test
    public void shouldUpdateExistingEmployee() {
        Employee employee = new Employee(1, 20000);
        employeeRepository.save(employee);

        assertEquals(20000, employeeRepository.getMap().get(1L).getSalary());
    }


}