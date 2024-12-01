/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.banktransactionversion01.filter;

import com.mycompany.banktransactionversion01.model.BankTransaction;

/**
 *
 * @author Huynh Cong Hung
 */
public interface BankTransactionFilter {
    boolean test(BankTransaction bantransactions);
}
