package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRepositoryTest {

    List<Employee> mockingRepository = List.of(
            new Employee(1, 10000),
            new Employee(2, 10000),
            new Employee(3, 10000),
            new Employee(4, 10000),
            new Employee(5, 10000)
    );
    EmployeeRepository employeeRepository = new EmployeeRepositoryImplementation(mockingRepository);

    @Test
    void shouldSaveNewEmployee() {
        Employee employee = new Employee(6, 10000);
        employeeRepository.save(employee);

        assertEquals(6, employeeRepository.getRepository().size());
    }

    @Test
    void shouldUpdateExisitingEmployee() {
        Employee employee = new Employee(1, 20000);
        employeeRepository.save(employee);

        assertEquals(20000, employeeRepository.getRepository().get(1L).getSalary());
    }
}