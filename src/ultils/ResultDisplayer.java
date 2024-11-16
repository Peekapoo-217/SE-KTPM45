/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultils;

import banktransactions.Transaction;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Huynh Cong Hung
 */
public class ResultDisplayer {
        public void displayTotalProfit(double total){
        System.out.println("Personal Collection: "+ total);
        var result = (total > 0) ? "The total is positive\n" :
                      (total < 0) ? "The total is negative\n":
                      "The total is zero\n"; 
        System.out.println(result);
    }
    
    public void displayTransactionCount(int month, int count){
        System.out.println("Transaction in "+ month + ":" + count);
    }
    
    public void displayTopExpense(List<Transaction> transactions){
        System.out.println("\nTop 10 expense:\n ");
        for(Transaction item : transactions){
            System.out.println(item);
        }    
    }
    
    public void displayMaxExpenseCategory(String category, double expense) {
        if (category == null) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("Category with the highest spending: " + category);
            System.out.println("Total spending: $" + expense);
        }
    }
}
