/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banktransactionversion01;
import com.mycompany.banktransactionversion01.model.BankTransaction;
import com.mycompany.banktransactionversion01.parser.BankStatementCSVParser;
import com.mycompany.banktransactionversion01.service.BankStatementProcessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankTransactionVersion01 {

    public static void main(String[] args) {
        List<String> lines = readCSVFile("transactions.csv");


        BankStatementCSVParser parser = new BankStatementCSVParser();
        List<BankTransaction> transactions = parser.parseLinesFromCSV(lines);


        BankStatementProcessor processor = new BankStatementProcessor();


        double netProfit = processor.calculateNetProfit(transactions);
        System.out.println("Net Profit: " + netProfit);


        long transactionCount = processor.countTransactionsInMonth(transactions, 1, 2017);
        System.out.println("Transactions in January 2017: " + transactionCount);


        List<BankTransaction> top10Expenses = processor.findTop10Expenses(transactions);
        System.out.println("Top 10 Expenses: ");
        top10Expenses.forEach(System.out::println);


        String category = processor.findCategoryWithMostSpending(transactions);
        System.out.println("Category with most spending: " + category);
    }


    public static List<String> readCSVFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Bỏ qua dòng tiêu đề
            
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
