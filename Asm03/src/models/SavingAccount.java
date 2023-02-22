package models;

import interfaces.ReporService;
import interfaces.WithDraw;
import Object.Account ;

public class SavingAccount extends Account  {
    final double  SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    public SavingAccount() {
        super();
        this.setLoaiTaiKhoan("SavingAccount");
    }

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.setLoaiTaiKhoan("SavingAccount");
    }

    @Override
    public double getFeeWithDraw(double amount) {
        return 0;
    }

    @Override
    protected double sodu(double amount){
        return  this.getBalance()-amount-this.getFeeWithDraw(amount);
    }
    @Override
    public boolean withDraw(double amount) {
        double newBalance=0;
        if(isAccepted(amount)){
            newBalance= this.getBalance()-amount;
            this.setBalance(newBalance);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        if(amount<SAVINGS_ACCOUNT_MAX_WITHDRAW && (this.getBalance()-amount)>0)
            return true;
        return false;
    }
}
