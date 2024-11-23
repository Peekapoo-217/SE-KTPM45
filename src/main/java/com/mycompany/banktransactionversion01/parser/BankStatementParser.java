package com.mycompany.banktransactionversion01.parser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.List;
/**
 *
 * @author Huynh Cong Hung
 */
public interface BankStatementParser {

    BankTransaction parseFromCSV(String line);

    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
