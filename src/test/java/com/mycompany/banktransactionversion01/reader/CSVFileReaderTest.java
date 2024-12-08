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
	    String sensitiveFilePath = "sensitive_transactions.csv";
	    String transactionFilePath = "transaction.csv";

	    // Tạo tệp với dữ liệu nhạy cảm trong thư mục resources
	    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/test/resources", sensitiveFilePath))) {
	        writer.write("ID,Amount,Date,Password\n");
	        writer.write("1,100,2024-12-01,secret123\n");
	        writer.write("2,200,2024-12-02,supersecret456\n");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Kiểm tra xem tệp sensitive_transactions.csv có tồn tại và chứa dữ liệu nhạy cảm
	    try {
	        CSVFileReader csvFileReader = new CSVFileReader();
	        List<String> sensitiveLines = csvFileReader.readFile(sensitiveFilePath);

	        // Kiểm tra xem tệp sensitive_transactions.csv có chứa mật khẩu
	        for (String line : sensitiveLines) {
	            assertTrue(line.contains("secret123") || line.contains("supersecret456"),
	                    "Sensitive data should be present in the sensitive file: " + line);
	        }
	    } catch (Exception e) {
	        fail("An error occurred while reading sensitive data file: " + e.getMessage());
	    }

	    // Kiểm tra tệp transaction.csv không chứa dữ liệu nhạy cảm
	    try {
	        CSVFileReader csvFileReader = new CSVFileReader();
	        List<String> transactionLines = csvFileReader.readFile(transactionFilePath);

	        // Kiểm tra rằng không có dữ liệu nhạy cảm (như mật khẩu) trong tệp transaction.csv
	        for (String line : transactionLines) {
	            assertFalse(line.contains("secret123") || line.contains("supersecret456"),
	                    "Transaction file should not contain sensitive data: " + line);
	        }
	    } catch (Exception e) {
	        fail("An error occurred while reading transaction file: " + e.getMessage());
	    }

	    // Clean-up: xóa tệp sau khi kiểm thử
	    try {
	        Files.delete(Paths.get("src/test/resources", sensitiveFilePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
