/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banktransactions.Require1;

import banktransactions.Transaction;
import ultils.*;
import banktransactions.TransactionStrategy;
import java.util.List;

/**
 *
 * @author Huynh Cong Hung
 */
public class TotalProfitStrategy implements TransactionStrategy{
    public ResultDisplayer displayResult;
    
    public TotalProfitStrategy(ResultDisplayer displayerResult){
        this.displayResult = displayerResult;
    }
    
    @Override
    public void execute(List<Transaction> transactions){
        double total = 0;
        for(Transaction item : transactions){
            total += item.getAmount();
        }
        
        displayResult.displayTotalProfit(total);
}
}
