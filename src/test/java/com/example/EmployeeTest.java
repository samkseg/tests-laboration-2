package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {

    @Test
    void shouldCreateEmployee() {
        Employee e = new Employee(7, 30000);

        assertEquals(7, e.getId());
    }

    @Test
    void shouldPayEmployee() {
        Employee e = new Employee(7, 30000);

        e.setPaid(true);

        assertTrue(e.isPaid());
    }

    @Test
    void shouldRaiseSalary() {
        Employee e = new Employee(7, 30000);

        e.setSalary(40000);

        assertEquals(40000, e.getSalary());
    }

    @Test
    void shouldSetNewId() {
        Employee e = new Employee(7, 30000);

        e.setId(8);

        assertEquals(8, e.getId());
    }

    @Test
    void toStringTest() {
        Employee e = new Employee(7, 30000);

        assertEquals("Employee [id=7, salary=30000.0]", e.toString());
    }
}
