/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banktransactions;

import banktransactions.Require1.TotalProfitStrategy;
import banktransactions.Require2.MonthlyTransactionCountStrategy;
import banktransactions.Require3.TopExpensesStrategy;
import banktransactions.Require4.HighestSpendingCategoryStrategy;
import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
//import banktransactions.Require4.HighestSpendingCategoryStrategy;

import java.util.ArrayList;
import java.util.List;
import ultils.ResultDisplayer;
import ultils.TransactionReader;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Read data from file
        TransactionReader transactionReader = new TransactionReader();
        List<Transaction> transactions = transactionReader.readTransactionFromFile("transactions.csv");

//        // Display list of Transaction
//        System.out.println("Loaded Transactions:");
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }

        //Initialize the variable to display these method
        ResultDisplayer resultDisplayer = new ResultDisplayer();

        //Test the Require 1
        TotalProfitStrategy totalProfitStrategy = new TotalProfitStrategy(resultDisplayer);
        totalProfitStrategy.execute(transactions);
        
        //Test the Require 2
        MonthlyTransactionCountStrategy monthlyTransactionCountStrategy = new MonthlyTransactionCountStrategy(resultDisplayer); 
        monthlyTransactionCountStrategy.setMonth(LocalDate.of(2017, 2, 2));
        monthlyTransactionCountStrategy.execute(transactions);
        
        //Test the Require 3
        TopExpensesStrategy topExpensesStrategy = new TopExpensesStrategy(resultDisplayer); 
        topExpensesStrategy.execute(transactions);
        
        //Test the Require 4
        System.out.println("\nExecuting MaxExpenseCategoryStrategy...");
        HighestSpendingCategoryStrategy maxExpenseStrategy = new HighestSpendingCategoryStrategy(resultDisplayer);
        maxExpenseStrategy.execute(transactions);
    }
    
}
