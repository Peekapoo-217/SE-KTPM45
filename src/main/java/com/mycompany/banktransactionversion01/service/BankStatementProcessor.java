package com.mycompany.banktransactionversion01.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.banktransactionversion01.analyzer.BankStatementAnalyzer;
import com.mycompany.banktransactionversion01.analyzer.BankTransactionSummarize;
import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankStatementProcessor {
    private BankTransactionSummarize bankTransactionSummarize;
    private BankStatementAnalyzer bankStatementAnalyzer;

    public BankStatementProcessor() {
        this.bankTransactionSummarize = new BankTransactionSummarize();
        this.bankStatementAnalyzer = new BankStatementAnalyzer();
    }

    // Tính tổng thu nhập và chi phí
    public double calculateNetProfit(List<BankTransaction> transactions) {
        return bankTransactionSummarize.calculateNetProfit(transactions);
    }

    // Đếm số giao dịch trong một tháng cụ thể
    public long countTransactionsInMonth(List<BankTransaction> transactions, int month, int year) {
        return bankTransactionSummarize.countTransactionsInMonth(transactions, month, year);
    }

    // Tìm top-10 chi tiêu lớn nhất (chi phí âm lớn nhất)
    public List<BankTransaction> findTop10Expenses(List<BankTransaction> transactions) {
        return bankStatementAnalyzer.findTop10Expenses(transactions);
    }

    // Xác định danh mục chi tiêu lớn nhất
    public String findCategoryWithMostSpending(List<BankTransaction> transactions) {
        return bankStatementAnalyzer.findCategoryWithMostSpending(transactions);
    }
}
