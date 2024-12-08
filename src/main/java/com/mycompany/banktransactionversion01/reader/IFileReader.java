package com.mycompany.banktransactionversion01.reader;

import java.util.List;

public interface IFileReader {
	List<String> readFile(String filename);
}
