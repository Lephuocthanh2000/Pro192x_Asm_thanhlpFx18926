package Object;

import interfaces.ReporService;
import interfaces.WithDraw;
import models.Transaction;
import models.Untils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account implements WithDraw, ReporService {
    private String accountNumber;
    private double balance;

    private String loaiTaiKhoan;

    // mỗi tài khoản nó sẽ có mảng danh sách giao dịch
    protected List<Transaction> listTransaction = new ArrayList<Transaction>();
    protected   static Untils untils = new Untils();

    public List<Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<Transaction> listTransaction) {
        this.listTransaction = null;
    }

    private static  final Scanner sc = new Scanner(System.in);
    //constructor
    public  Account(){
        this.accountNumber =" ";
        this.balance= 0.00;
        this.loaiTaiKhoan=" ";
    }
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // method
    public boolean isPremium(){
        return this.balance >= 10000000;
    }

    public void inputAccount(){
        System.out.println("Nhap ma STK gom 6 chu so: ");
        String stk = sc.next();
        if(stk.length()==6){
            this.setAccountNumber(stk);
            System.out.println("Nhap so du : ");
            double soDu = sc.nextDouble();
            if(soDu >= 50000){
                this.setBalance(soDu);
            }else {
                System.out.println("So du khong hop le");
                this.inputAccount();
            }
        }else {
            System.out.println("STK khong hop le");
            this.inputAccount();
        }

    }

    // setter and getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    //tinh so du


    @Override
    public  String toString() {
        return this.accountNumber + " |           " + this.balance + " đ";
    }
    @Override
    public boolean withDraw(double amount) {
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        return false;
    }

    @Override
    public double getFeeWithDraw(double amount) {
        return 0;
    }

    @Override
    public void log(double amount) {
        final String title = "Giao dich";
        final String ATM_ID ="DIGITAL-BANK-ATM-2022";
        System.out.println(untils.getDevider());
        System.out.printf("%28s %n",title);
        System.out.printf(" Ngay giao dich: %22s %n ",untils.getDateTime());
        System.out.printf("ATM ID: %22s %n ",ATM_ID);
        System.out.printf("STK: %22s %n",this.getAccountNumber());
        System.out.printf("SO TIEN:%22s %n ",untils.formatBalance(amount));
        System.out.printf("SO DU:%22s %n",untils.formatBalance(this.getBalance()-this.getFeeWithDraw(amount)));
        System.out.printf("PHI+VAT:%22s %n  ", untils.formatBalance(this.getFeeWithDraw(amount)));
        System.out.println(untils.getDevider());
    }
}
