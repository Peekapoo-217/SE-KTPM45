/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banktransactions.Require4;

import banktransactions.Transaction;
import banktransactions.TransactionStrategy;
import ultils.ResultDisplayer;

import java.util.*;
/**
 *
 * @author Huynh Cong Hung
 */
public class HighestSpendingCategoryStrategy implements TransactionStrategy{
    private ResultDisplayer resultDisplayer;

    public HighestSpendingCategoryStrategy(ResultDisplayer resultDisplayer) {
        this.resultDisplayer = resultDisplayer;
    }

    @Override
    public void execute(List<Transaction> transactions) {
        Map<String, Double> categoryExpenses = new HashMap<>();

        // Tính tổng chi tiêu theo từng danh mục
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) { // Chỉ xét các giao dịch tiêu tiền
                categoryExpenses.put(
                        transaction.getDescription(),
                        categoryExpenses.getOrDefault(transaction.getDescription(), 0.0) + Math.abs(transaction.getAmount())
                );
            }
        }

        // Tìm danh mục có tổng chi tiêu cao nhất
        String maxCategory = null;
        double maxExpense = 0.0;

        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            if (entry.getValue() > maxExpense) {
                maxExpense = entry.getValue();
                maxCategory = entry.getKey();
            }
        }

        // Hiển thị kết quả
        resultDisplayer.displayMaxExpenseCategory(maxCategory, maxExpense);
    }
}
