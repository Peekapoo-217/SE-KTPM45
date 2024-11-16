/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package banktransactions;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public interface TransactionStrategy {
    public void execute(List<Transaction> transactions);
    
//    public void execute(List<Transaction> transactions, int T);
}
