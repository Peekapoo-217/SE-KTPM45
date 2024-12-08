package com.mycompany.banktransactionversion01.parser;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import com.mycompany.banktransactionversion01.model.BankTransaction;
import org.junit.jupiter.api.Test;

public class BankStatementCSVParserTest {

	private BankStatementCSVParser statementParser = new BankStatementCSVParser();
	@Test
	public void shouldParseOneCorrectLine() throws Exception {
		final String line = "30-01-2017,-50,Tesco";
		final BankTransaction result = statementParser.parseFromCSV(line);
		final BankTransaction expected
		= new BankTransaction (LocalDate. of (2017, Month. JANUARY, 30), -50, "Tesco");
		final double tolerance = 0.0d;
		assertEquals(expected.getDateOfTransaction(), result.getDateOfTransaction());
		assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		assertEquals(expected.getDescription(), result.getDescription());
		}
	}
