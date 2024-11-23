package com.mycompany.banktransactionversion01.model;


import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Huynh Cong Hung
 */
public class BankTransaction {
    private LocalDate dateOfTransaction;
    
    //Describe received or spent
    private double amount;
    
    //Describe category of transaction
    private String description;
    
    public BankTransaction(LocalDate dateOfTransaction, double amount, String description){
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString(){
        return "Transaction "+ dateOfTransaction + "\nAmount " +amount + "\nDescription " + description ;
    }
}
