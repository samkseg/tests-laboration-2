package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {

    @Test
    public void shouldCreateEmployee() {
        Employee e = new Employee(7, 30000);

        assertEquals(7, e.getId());
    }

    @Test
    public void shouldPayEmployee() {
        Employee e = new Employee(7, 30000);

        e.setPaid(true);

        assertTrue(e.isPaid());
    }

    @Test
    public void shouldRaiseSalary() {
        Employee e = new Employee(7, 30000);

        e.setSalary(40000);

        assertEquals(40000, e.getSalary());
    }

    @Test
    public void shouldSetNewId() {
        Employee e = new Employee(7, 30000);

        e.setId(8);

        assertEquals(8, e.getId());
    }

    @Test
    public void toStringTest() {
        Employee e = new Employee(7, 30000);

        assertEquals("Employee [id=7, salary=30000.0]", e.toString());
    }
}
