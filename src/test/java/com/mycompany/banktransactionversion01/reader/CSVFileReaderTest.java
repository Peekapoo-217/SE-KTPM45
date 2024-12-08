package com.mycompany.banktransactionversion01.reader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.mycompany.banktransactionversion01.model.BankTransaction;

import java.util.List;
import java.io.InputStream;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

class CSVFileReaderTest {
	@Test
	public void testReadFile_FileExist() {
		IFileReader csvReader = new CSVFileReader();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("transactions.csv");

		assertNotNull(inputStream, "The file 'transactions.csv' should exist in the resources folder.");

		if (inputStream != null) {
			List<String> lines = csvReader.readFile("transactions.csv");

			assertFalse(lines.isEmpty(), "The file should be read successfully and contain lines.");
		}
	}
	
	@Test
	void testFileReader_SensitiveData() {
	    String sensitiveFilePath = "transaction.csv";

	    // Đọc tệp CSV
	    List<String> lines = null;
	    try {
	        CSVFileReader csvFileReader = new CSVFileReader();
	        lines = csvFileReader.readFile(sensitiveFilePath);
	    } catch (Exception e) {
	        fail("An error occurred while reading the file: " + e.getMessage());
	    }

	    // Kiểm tra xem danh sách dòng có rỗng không
	    assertNotNull(lines);
	    assertFalse(lines.isEmpty(), "File should not be empty");

	    // Kiểm tra từng dòng trong tệp
	    for (String line : lines) {
	        // Tách các cột ra từ dòng (giả sử tệp CSV được phân tách bởi dấu phẩy)
	        String[] columns = line.split(",");

	        // Kiểm tra rằng tệp có đúng 3 cột (Date, Amount, Description)
	        assertEquals(3, columns.length, "Each line should have 3 columns");

	        // Kiểm tra định dạng ngày tháng (dd-MM-yyyy)
	        String date = columns[0].trim();
	        assertTrue(date.matches("\\d{2}-\\d{2}-\\d{4}"), "Date format is incorrect: " + date);

	        // Kiểm tra số tiền có phải là số hợp lệ không (kiểu Integer hoặc Double)
	        String amountStr = columns[1].trim();
	        try {
	            Double amount = Double.parseDouble(amountStr);
	            assertTrue(amount != 0, "Amount should not be zero: " + amountStr);
	        } catch (NumberFormatException e) {
	            fail("Amount is not a valid number: " + amountStr);
	        }

	        // Kiểm tra mô tả không rỗng
	        String description = columns[2].trim();
	        assertNotNull(description, "Description should not be null or empty");
	        assertFalse(description.isEmpty(), "Description should not be empty");
	    }
	}




	
}
