package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class EmployeeManagerTest {
    private List<Employee> mockingRepository = List.of(
            new Employee(1, 10000),
            new Employee(2, 10000),
            new Employee(3, 100000),
            new Employee(4, 10000),
            new Employee(5, 10000)
    );
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImplementation(mockingRepository);
    @Mock
    private BankService bankService = mock(BankService.class);
    private EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

    @Test
    public void shouldPayEmployees() {
        employeeManager.resetPaidEmployees();

        employeeManager.payEmployees();

        assertEquals(0, employeeManager.getNotPaidEmployees().size());
        verify(bankService, times(5)).pay(anyLong(), anyDouble());
    }

    @Test
    public void shouldReturnCountedPaidEmployees() {
        employeeManager.resetPaidEmployees();

        assertEquals(5, employeeManager.payEmployees());
    }
    @Test
    public void shouldThrowExceptionIfEmployeeNotPaid() {
        employeeManager.resetPaidEmployees();
        doThrow(new RuntimeException()).when(bankService).pay(anyLong(), eq(100000.0));

        assertEquals(4, employeeManager.payEmployees());
        assertEquals(Arrays.asList(employeeRepository.getMap().get(3L)), employeeManager.getNotPaidEmployees());
        verify(bankService, atLeast(5)).pay(anyLong(),anyDouble());
    }

    @Test
    public void shouldReturnNotPaidEmployees() {
        for (Employee employee : employeeRepository.getMap().values().stream().toList()) {
            employee.setPaid(true);
        }
        employeeRepository.getMap().get(3L).setPaid(false);

        assertEquals(1, employeeManager.getNotPaidEmployees().size());
    }

    @Test
    public void shouldResetAllEmployeesToNotPaid() {
        employeeManager.payEmployees();
        employeeManager.resetPaidEmployees();

        int count = 0;
        for (Employee employee : employeeRepository.getMap().values()) {
            if (!employee.isPaid()) {
                count++;
            }
        }
        assertEquals(employeeRepository.getMap().values().size(), count);
    }
}
