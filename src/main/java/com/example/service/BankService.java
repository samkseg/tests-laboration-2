package com.example.service;

public interface BankService {
	void pay(long id, double amount);

	int getPayments();
}
