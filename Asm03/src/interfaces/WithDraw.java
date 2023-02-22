package interfaces;

public interface WithDraw {
    // xử lý nghiệp vụ  rút tiền
    boolean  withDraw(double amount);
    // xác định xem giá trị có thỏa điều kiện rút tiền hay không
    boolean isAccepted (double amount);
    // tinh phi
    double getFeeWithDraw(double amount);
}
