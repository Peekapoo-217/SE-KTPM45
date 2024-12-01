package com.mycompany.banktransactionversion01.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.banktransactionversion01.analyzer.BankStatementAnalyzer;
import com.mycompany.banktransactionversion01.analyzer.BankTransactionSummarize;
import com.mycompany.banktransactionversion01.filter.BankTransactionFilter;
import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.List;
import java.time.Month;
import java.util.ArrayList;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankStatementProcessor {
    
    private BankTransactionSummarize bankTransactionSummarize;
    
    private BankStatementAnalyzer bankStatementAnalyzer;
    
    private List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }
    
        public BankStatementProcessor() {
        this.bankTransactionSummarize = new BankTransactionSummarize();
        this.bankStatementAnalyzer = new BankStatementAnalyzer();
    }
    
    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0 ;
        for(final BankTransaction bankTransaction : bankTransactions){
            result = bankTransactionSummarizer.summarize(result , bankTransaction);
        }
        return result;
    }
    
    
    //Require1
    public double calculateTotalAmount(){
        return summarizeTransactions((acc, bankTransaction) -> acc + bankTransaction.getAmount());
    }
    
    
    //Require2
    public double calculateTotalInMonth(Month month){
        return summarizeTransactions((acc, bankTransaction) -> bankTransaction.getDateOfTransaction().getMonth() 
            == month ? acc + bankTransaction.getAmount() : acc);
    }
    
    //Require 3
    public double calculateTotalByCategory(String category){
        return summarizeTransactions((acc, bankTransaction) -> 
            bankTransaction.getDescription().equalsIgnoreCase(category)
                ? acc + bankTransaction.getAmount() : acc);
    }
    
    

   
    public List<BankTransaction> findBankTransactions(BankTransactionFilter bankTransactionFilter){
        List<BankTransaction> result = new ArrayList<>();
        for(BankTransaction bankTransaction : bankTransactions){
            if(bankTransactionFilter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }return bankTransactions;
    }

    
    
  
    
    
    
//    // Tính tổng thu nhập và chi phí
//    public double calculateNetProfit(List<BankTransaction> transactions) {
//        return bankTransactionSummarize.calculateNetProfit(transactions);
//    }
//
//    // Đếm số giao dịch trong một tháng cụ thể
//    public long countTransactionsInMonth(List<BankTransaction> transactions, int month, int year) {
//        return bankTransactionSummarize.countTransactionsInMonth(transactions, month, year);
//    }
//
//    // Tìm top-10 chi tiêu lớn nhất (chi phí âm lớn nhất)
//    public List<BankTransaction> findTop10Expenses(List<BankTransaction> transactions) {
//        return bankStatementAnalyzer.findTop10Expenses(transactions);
//    }
//
//    // Xác định danh mục chi tiêu lớn nhất
//    public String findCategoryWithMostSpending(List<BankTransaction> transactions) {
//        return bankStatementAnalyzer.findCategoryWithMostSpending(transactions);
//    }
}
