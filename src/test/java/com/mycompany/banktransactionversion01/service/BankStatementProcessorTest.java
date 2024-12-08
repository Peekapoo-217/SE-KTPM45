package com.mycompany.banktransactionversion01.service;


import com.mycompany.banktransactionversion01.model.BankTransaction;
import com.mycompany.banktransactionversion01.service.BankStatementProcessor;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankStatementProcessorTest {

    private BankStatementProcessor processor;

    @BeforeEach
    public void setup() {

        List<BankTransaction> transactions = Arrays.asList(
            new BankTransaction(LocalDate.of(2017, 1, 30), -100, "Deliveroo"),
            new BankTransaction(LocalDate.of(2017, 1, 30), -50, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 1), 6000, "Salary"),
            new BankTransaction(LocalDate.of(2017, 2, 2), 2000, "Royalties"),
            new BankTransaction(LocalDate.of(2017, 2, 2), -4000, "Rent"),
            new BankTransaction(LocalDate.of(2017, 2, 3), 3000, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 5), -30, "Cinema")
        );

        processor = new BankStatementProcessor(transactions);
    }

    @Test
    public void testCalculateTotalAmount() {
        double totalAmount = processor.calculateTotalAmount();

        assertEquals(6820, totalAmount, 0.001); 
    }

    @Test
    public void testCalculateTotalInMonth() {

        double totalInFebruary = processor.calculateTotalInMonth(Month.FEBRUARY);

        assertEquals(6970, totalInFebruary, 0.001); 
    }

    @Test
    public void testCalculateTotalByCategory() {

        double totalForTesco = processor.calculateTotalByCategory("Rent");

        assertEquals(-4000, totalForTesco, 0.001);
    }
}
