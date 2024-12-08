package com.mycompany.banktransactionversion01;
import com.mycompany.banktransactionversion01.reader.*;
import com.mycompany.banktransactionversion01.exporter.Exporter;
import com.mycompany.banktransactionversion01.exporter.HtmlExporter;
import com.mycompany.banktransactionversion01.model.BankTransaction;
import com.mycompany.banktransactionversion01.model.SummaryStatistics;
import com.mycompany.banktransactionversion01.parser.BankStatementCSVParser;
import com.mycompany.banktransactionversion01.service.BankStatementProcessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Month;
import java.util.*;
import java.io.InputStreamReader;
import java.io.Reader;

public class BankTransactionVersion01 {

    public static void main(String[] args) {

        IFileReader csvReader = new CSVFileReader();
        
        List<String> lines = csvReader.readFile("transactions.csv");
        
        BankStatementCSVParser parser = new BankStatementCSVParser();
        List<BankTransaction> transactions = parser.parseLinesFromCSV(lines);

        BankStatementProcessor processor = new BankStatementProcessor(transactions);

        // Require 1
        double totalAmount = processor.calculateTotalAmount();
        System.out.println("Total Amount: " + totalAmount);

        // (Require 2)
        double totalInFebruary = processor.calculateTotalInMonth(Month.FEBRUARY);
        System.out.println("Total in February: " + totalInFebruary);


        //Require 3
        double totalRent = processor.calculateTotalByCategory("Rent");
        System.out.println("Total for Rent: " + totalRent); 
        
        
         SummaryStatistics stats = new SummaryStatistics(100, 500,100, 250);
         
         Exporter exporter = new HtmlExporter();
         
         String htmlReport = exporter.export(stats);
         
         System.out.println(htmlReport);
    }
}
