/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banktransactionversion01.parser;

/**
 *
 * @author Huynh Cong Hung
 */
public class CSVSyntaxException extends RuntimeException{
    public CSVSyntaxException() {
        super("Invalid CSV format.");
    }
    
     public CSVSyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
     
    public CSVSyntaxException(String message) {
        super(message);
    }
}
