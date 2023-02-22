package models;
import  Object.Account;

public class LoanAccount extends Account {
//    Hằng số: LOAN_ACCOUNT_WITHDRAW_FEE định nghĩa phí rút tiền cho tài khoản thường là 0.05.
    final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
//    Hằng số: LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE định nghĩa phí rút tiền tài khoản premium là 0.01.
    final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
//    Hằng số: LOAN_ACCOUNT_MAX_BALANCE định nghĩa hạn mức tối đa cho loại tài khoản này là: 100.000.000đ.
    final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    public LoanAccount() {
        super();
        this.setLoaiTaiKhoan("LoanAccount");
    }

    public LoanAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.setLoaiTaiKhoan("LoanAccount");
    }
    // function tính phí rút

    @Override
     public double getFeeWithDraw(double amount){
        if(this.isPremium()){
            return amount*LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
        }
        return amount*LOAN_ACCOUNT_WITHDRAW_FEE;
    }

    @Override
    protected double sodu(double amount){
        return  this.getBalance()-amount-this.getFeeWithDraw(amount);
    }
    @Override
    public boolean withDraw(double amount) {

        if(isAccepted(amount)){

            this.setBalance(sodu(amount));
            return true;
        }
        return false;
    }
    @Override
    public boolean isAccepted(double amount) {
        if(amount<=LOAN_ACCOUNT_MAX_BALANCE && (this.getBalance()-amount-this.getFeeWithDraw(amount))>=50000){
            return true;
        }
        return false;
    }
    @Override
    public void log(double amount) {
        String title ="Tai khoan  "+this.getLoaiTaiKhoan();
        final String ATM_ID ="DIGITAL-BANK-ATM-2022";
        System.out.println(untils.getDevider());
        System.out.printf("%28s %n",title);
        System.out.printf(" Ngay giao dich: %22s %n ",untils.getDateTime());
        System.out.printf("ATM ID: %22s %n ",ATM_ID);
        System.out.printf("STK: %22s %n",this.getAccountNumber());
        System.out.printf("SO TIEN:%22s %n ",untils.formatBalance(amount));
        System.out.printf("SO DU:%22s %n",untils.formatBalance(this.getBalance()));
        System.out.printf("PHI+VAT:%22s %n  ", untils.formatBalance(this.getFeeWithDraw(amount)));
        System.out.println(untils.getDevider());
    }
}
