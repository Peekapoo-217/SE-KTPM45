/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banktransactions.Require3;

import banktransactions.Transaction;
import banktransactions.TransactionStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import ultils.*;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public class TopExpensesStrategy implements TransactionStrategy{
    private ResultDisplayer displayerResult;
    
    private Transaction highestExpense;
    
    public TopExpensesStrategy(ResultDisplayer displayerResult){
        this.displayerResult = displayerResult;
    }

    //Require3:
    /*Summary
    Reckon top 10 spending
    parameter: List of transaction
    result: list top 10 expense
    Summary*/
    @Override
    public void execute(List<Transaction> transactions){
        List<Transaction> listExpense = new ArrayList<>();
        for(Transaction item : transactions){
            if(item.getAmount() < 0){
                listExpense.add(item);
            }
        }
        listExpense.sort(Comparator.comparingDouble(Transaction :: getAmount));
        if(listExpense.size() > 10){
            listExpense = listExpense.subList(0, 10);
        }
        displayerResult.displayTopExpense(listExpense);
        
        
        if(!listExpense.isEmpty()){
            highestExpense = listExpense.get(0);
        }
    }
    
    public Transaction getHighestExpense(){
        return highestExpense;
    }
    
    
}
