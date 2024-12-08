package com.mycompany.banktransactionversion01.parser;

import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.List;

public interface IBankStatementParser {

    BankTransaction parseFromCSV(String line);

    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
