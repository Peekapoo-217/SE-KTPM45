# Đánh Giá Khó Khăn và Giải Pháp Cho Demo Strategy Design Pattern

## 1. Khó Khăn

### 1.1. Cấu trúc khá phức tạp
- **Vấn đề**: Việc tạo một interface và các class riêng cho từng chiến lược (strategy) như `TotalProfitStrategy`, `MonthlyTransactionCountStrategy`, ... làm tăng số lượng tệp và độ phức tạp của dự án. Mỗi khi có yêu cầu mới, cần tạo một class mới.
- **Hậu quả**: 
  - Dễ gây nhầm lẫn khi quản lý nhiều chiến lược trong các thư mục khác nhau.
  - Khó mở rộng nếu không duy trì đồng bộ interface hoặc quy ước.

### 1.2. Phương thức `execute()` thiếu tính linh hoạt
- **Vấn đề**: Các chiến lược cần thêm tham số khác  (như `MonthlyTransactionCountStrategy` cần parameter `month`, còn các chiến lược khác thì không). Điều này dẫn đến việc phải kiểm tra hoặc xử lý ngoại lệ khi thực thi.
- **Hậu quả**: Thiếu nhất quán trong việc sử dụng interface `TransactionStrategy`.

### 1.3. Khả năng tái sử dụng mã thấp
- **Vấn đề**: Các chiến lược như `TopExpensesStrategy` và `MaxExpenseCategoryStrategy` có các đoạn logic lặp lại, ví dụ: lọc giao dịch theo `amount`.
- **Hậu quả**: Gây khó khăn trong việc bảo trì và cập nhật logic chung.

### 1.4. Xử lý lỗi còn thô sơ
- **Vấn đề**: Các lỗi như thiếu tham số (`month`) hoặc dữ liệu không hợp lệ được xử lý bằng cách in ra `System.out` hoặc ném ngoại lệ, thay vì áp dụng cơ chế thông báo rõ ràng.
- **Hậu quả**: Khó khăn trong việc gỡ lỗi hoặc sử dụng lại code ở môi trường khác.

### 1.5. Đọc file và phân tích dữ liệu thiếu tối ưu
- **Vấn đề**: Hàm đọc file chứa nhiều logic phức tạp, ví dụ: parsing thủ công và xử lý lỗi cho từng dòng.
- **Hậu quả**: Mã nguồn trở nên khó đọc, khó mở rộng và dễ gây lỗi khi định dạng file thay đổi.


## 2. Giải Pháp

### 2.1. Tối ưu hóa Strategy Pattern bằng cách:
-  Sử dụng **enum-based strategy** hoặc một danh sách các chiến lược (**list of strategies**) trong một class duy nhất.  
Thay vì tạo nhiều class, định nghĩa chiến lược dưới dạng phương thức **lambda** hoặc **method reference**.  

**Ví dụ**:
```
public enum StrategyType {
    TOTAL_PROFIT(transactions -> {
        double total = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        return "Total Profit: " + total;
    }),
    TOP_EXPENSE(transactions -> {
        return "Top Expense: " + transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(10).toList();
    });

    private final Function<List<Transaction>, String> strategy;

    StrategyType(Function<List<Transaction>, String> strategy) {
        this.strategy = strategy;
    }

    public String execute(List<Transaction> transactions) {
        return strategy.apply(transactions);
    }
}
````

### Lợi ích:
- Giảm số lượng class
- Dễ dàng sửa đổi strategy


## 2.2. Làm rõ tham số chiến lược
Giải pháp: Thêm các setter để cung cấp tham số bổ sung trước khi thực thi chiến lược.
Ví dụ:
````
public class MonthlyTransactionCountStrategy implements TransactionStrategy {
    private LocalDate month;

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    @Override
    public void execute(List<Transaction> transactions) {
        if (month == null) {
            throw new IllegalStateException("Month must be set before execution.");
        }
        // Logic tính toán...
    }
}
````
Lợi ích:
- Giảm phụ thuộc vào các tham số không cần thiết trong interface.
- Đảm bảo tính rõ ràng và tường minh khi sử dụng chiến lược.
