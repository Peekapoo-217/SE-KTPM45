package com.mycompany.banktransactionversion01.parser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankStatementCSVParser implements BankStatementParser{
    
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    private static final int EXPECTED_ATTRIBUTES_LENGTH = 3;
    @Override
    public BankTransaction parseFromCSV(String line) {
        
        final String[] columns = line.split(",");
        if (columns.length < EXPECTED_ATTRIBUTES_LENGTH) {
            throw new CSVSyntaxException("Invalid CSV format: " + line); // Ném ngoại lệ nếu số cột không hợp lệ
        }
        
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFromCSV(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFromCSV(line));
        }
        return bankTransactions;
    }
}
