package com.example;

public class BankServiceSpy implements BankService{
    private int payments;
    @Override
    public void pay(long id, double amount) {
        this.payments++;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }
}