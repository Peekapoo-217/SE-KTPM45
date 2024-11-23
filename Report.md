## Sơ đồ UML mô tả các gói giải quyết các Usecase

![markdown](https://www.planttext.com/api/plantuml/png/r5RBRjim4BphAtXq04T8haLXn8qTe42I6fNG7WkQMZj4H58WLq6LDb_MGp-flz2Lh4OlghPxIQg3B92pipkSvSA_VloySCWjvYeDCYxk-HQOC2fK1RqphejmpVKzMguT5oYDVW3hwEViF5GcWPHz2nWz8kNEiNS4ZHjelLS-f-pQ29ukE09BwFLXqyArK8d9roamhaokiRKUePLwon9mmigi4yJwQIT_IJNjPfXwY4zQp0tJ5d3H9vkqeJKluUOLTMUppbAID8by23IxZthlANWAZhM5QvuMZs07paH80XHed7SHjLJfy6tl96Ti8tKIc-pyRFar0-t0JVouLYNE8wkakQJiMsEBpnBlRep3Y0YJKkgXZ7GKewqMvKfnAn-XewdsX3mKUKhfRm5Nrcma7gaYDQH1bAwsuEwzlZ4QxmxWcZAfaQaIlViiWDj_TpZZrZsxHtHWDrn0r-DL6-Ez9goYkR96NKQV9hLHgTHmihShgiXhWhe_uHLknp6hICOyUowGekeQfShIQidjaN3AQ5IX5AoyYR5KS6MiuaZwsM8UBx-ivd6y_7ZxufAFTvHqFaW1urUMsbQ0SwPx7AENO3soqOiTJeIrRxLteCEYV8FmDL-w_sVYKIlvZGh3sQ2xtx2SwWr6ks9FZAVPF14DtM6Xmz9zSSqq2CFlCzyS6CVxH0aBX7J11Pru-TVcDm000F__0m00)


### Giải thích cách tác giả sử dụng để giải quyết vấn đề về SRP:

#### **Tách từng chức năng thành các lớp riêng biệt:**
  - Đọc dữ liệu đầu vào.
  - Phân tích (parsing) dữ liệu từ tệp CSV.
  - Xử lý kết quả.
  - Báo cáo kết quả.
- Để tuân thủ nguyên tắc SRP, tác giả tách phần logic phân tích dữ liệu CSV ra thành một lớp riêng biệt có tên `BankStatementCSVParser`.

#### **Tạo lớp `BankStatementCSVParser`:**
- Lớp này chịu trách nhiệm duy nhất là phân tích dữ liệu CSV và chuyển đổi sang đối tượng `BankTransaction`.
- Tác giả triển khai hai phương thức chính:
  - `parseFromCSV(String line)`: Phân tích một dòng CSV để tạo một đối tượng `BankTransaction`.
  - `parseLinesFromCSV(List<String> lines)`: Phân tích danh sách các dòng CSV và trả về danh sách các đối tượng `BankTransaction`.
- Việc này giúp loại bỏ các trách nhiệm không liên quan khỏi lớp chính, giúp các thành phần khác có thể tái sử dụng mà không cần hiểu chi tiết việc phân tích CSV.

#### **Định nghĩa lớp `BankTransaction`:**
- Lớp này được dùng để mô hình hóa một giao dịch ngân hàng với các thuộc tính như:
  - Ngày (`date`)
  - Số tiền (`amount`)
  - Mô tả (`description`)
- `BankTransaction` chỉ có trách nhiệm duy nhất là biểu diễn dữ liệu của một giao dịch, không liên quan đến logic xử lý hay phân tích.

#### **Kết quả của việc áp dụng SRP:**
- **Dễ bảo trì:** Nếu sau này cần thay đổi cách xử lý dữ liệu CSV (ví dụ thêm định dạng JSON), chỉ cần thay đổi lớp `BankStatementCSVParser` mà không ảnh hưởng đến các phần khác.
- **Dễ hiểu:** Mỗi lớp có một nhiệm vụ cụ thể, làm cho mã nguồn rõ ràng hơn.
- **Tái sử dụng:** Lớp `BankStatementCSVParser` có thể được sử dụng lại trong các bối cảnh khác mà không bị ràng buộc vào logic xử lý dữ liệu.

---

### **Tóm lại:**
Tác giả đã giải quyết vấn đề bằng cách chia nhỏ trách nhiệm vào các lớp riêng biệt, đảm bảo rằng mỗi lớp chỉ có **một lý do để thay đổi**, qua đó tuân thủ nguyên tắc **Single Responsibility Principle (SRP)**.

---
