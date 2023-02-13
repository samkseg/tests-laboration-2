package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {

	private final EmployeeRepository employeeRepository;
	private final BankService bankService;

	public EmployeeManager(EmployeeRepository employeeRepository, BankService bankService) {
		this.employeeRepository = employeeRepository;
		this.bankService = bankService;
	}

	public int payEmployees() {
		int payments = 0;
		for (Employee employee : employeeRepository.findAll()) {
			try {
				bankService.pay(employee.getId(), employee.getSalary());
				employee.setPaid(true);
				payments++;
			} catch (RuntimeException e) {
				employee.setPaid(false);
			}
		}
		return payments;
	}

	public void resetPaidEmployees() {
		for (Employee employee : employeeRepository.findAll()){
			employee.setPaid(false);
		}
	}

	public List<Employee> getNotPaidEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().filter(employee -> ! employee.isPaid()).collect(Collectors.toList());
	}
}
