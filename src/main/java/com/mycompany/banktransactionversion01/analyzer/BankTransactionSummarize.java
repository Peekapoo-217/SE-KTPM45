package com.mycompany.banktransactionversion01.analyzer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankTransactionSummarize {

    
    public double calculateNetProfit(List<BankTransaction> transactions) {
        double total = 0;
        for (BankTransaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    // Đếm số giao dịch trong một tháng cụ thể
    public long countTransactionsInMonth(List<BankTransaction> transactions, int month, int year) {
        long count = 0;
        for (BankTransaction transaction : transactions) {
            if (transaction.getDateOfTransaction().getMonthValue() == month &&
                transaction.getDateOfTransaction().getYear() == year) {
                count++;
            }
        }
        return count;
    }
}
