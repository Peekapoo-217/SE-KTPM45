/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultils;
import java.util.ArrayList;
import java.util.List;
import banktransactions.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Huynh Cong Hung
 */
public class TransactionReader {
    public List<Transaction> readTransactionFromFile(String filePath){
        List<Transaction> transactions = new ArrayList<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            
            String line;
            
            br.readLine();
            
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");

                LocalDate date = LocalDate.parse(parts[0].trim(), formatter);
                
                double amount = Double.parseDouble(parts[1].trim());
                
                String category = parts[2].trim();
                
                transactions.add(new Transaction(date, amount, category));
            }
        }catch(IOException e){
//                System.out.println("Error reading file!");
            System.out.println(e.getMessage());
             
        }
        return transactions;
    }
}
