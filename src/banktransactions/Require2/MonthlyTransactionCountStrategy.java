/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banktransactions.Require2;

import ultils.*;
import banktransactions.TransactionStrategy;
import java.time.LocalDate;
import banktransactions.Transaction;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public class MonthlyTransactionCountStrategy implements TransactionStrategy{
    
    public ResultDisplayer resultDisplayer;
    
    private LocalDate month;
    
    public MonthlyTransactionCountStrategy(ResultDisplayer resultDisplayer){
        this.resultDisplayer = resultDisplayer;
    }
    
    
//Require2:
    /*Summary
    Calculate the quantity of transaction
    in 1 month?
    Summary*/
    
    /*Calculate the quantity of transaction in 1 month
    Parameter: List of transaction
    Result: Quantity in 1 month
    */
    
    public void setMonth(LocalDate month){
        this.month = month;
    }
    
    public void execute(List<Transaction> transactions){

        if(this.month == null){
            throw new IllegalArgumentException("Month must be set before!!");
        }
        
        long quantity = 0;
        for(Transaction item : transactions){
            if(item.getDateOfTransaction().getMonth() == month.getMonth() && item.getDateOfTransaction().getYear() == month.getYear()){
                quantity++;
            }
        }
        resultDisplayer.displayTransactionCount(0, 0); //
    }
}
