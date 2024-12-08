package com.mycompany.banktransactionversion01.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CSVFileReader implements IFileReader {
    
    @Override
    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                CSVFileReader.class.getClassLoader().getResourceAsStream(fileName)))) {

            if (br == null) {
                System.out.println("File not found in resources: " + fileName);
                return lines;
            }

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
