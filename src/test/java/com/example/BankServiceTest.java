package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankServiceTest {

    private BankService bankService = new BankServiceSpy();

    @Test
    public void shouldIncreaseCountedPayments() {
        bankService.pay(1,10000);
        bankService.pay(2,10000);
        bankService.pay(3,10000);
        assertEquals(3, bankService.getPayments());
    }
}
