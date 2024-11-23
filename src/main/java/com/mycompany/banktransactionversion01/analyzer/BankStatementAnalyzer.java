package com.mycompany.banktransactionversion01.analyzer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.banktransactionversion01.model.BankTransaction;
import java.util.*;
/**
 *
 * @author Huynh Cong Hung
 */
public class BankStatementAnalyzer {
     // Tìm top-10 chi tiêu lớn nhất (chi phí âm lớn nhất)
    public List<BankTransaction> findTop10Expenses(List<BankTransaction> transactions) {
        List<BankTransaction> expenses = new ArrayList<>();
        
        // Lọc các giao dịch có chi phí (âm)
        for (BankTransaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                expenses.add(transaction);
            }
        }

        // Sắp xếp các giao dịch theo chi phí tăng dần
        expenses.sort(Comparator.comparingDouble(BankTransaction::getAmount));

        // Lấy tối đa 10 giao dịch
        return expenses.subList(0, Math.min(expenses.size(), 10));
    }

    // Xác định danh mục chi tiêu lớn nhất
    public String findCategoryWithMostSpending(List<BankTransaction> transactions) {
        Map<String, Double> categorySpending = new HashMap<>();

        // Tính tổng chi phí cho từng danh mục
        for (BankTransaction transaction : transactions) {
            if (transaction.getAmount() < 0) { // Chỉ tính các giao dịch chi tiêu
                String category = transaction.getDescription();
                categorySpending.put(category, categorySpending.getOrDefault(category, 0.0) + transaction.getAmount());
            }
        }

        // Tìm danh mục có chi tiêu lớn nhất
        String maxCategory = null;
        double maxSpending = Double.POSITIVE_INFINITY; // Chi phí âm lớn nhất là số âm gần 0

        for (Map.Entry<String, Double> entry : categorySpending.entrySet()) {
            if (entry.getValue() < maxSpending) {
                maxSpending = entry.getValue();
                maxCategory = entry.getKey();
            }
        }

        return maxCategory != null ? maxCategory : "No expenses found";
    }
}
