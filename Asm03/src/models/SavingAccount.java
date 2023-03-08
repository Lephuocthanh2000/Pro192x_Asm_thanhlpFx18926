package models;

import interfaces.ReporService;
import interfaces.WithDraw;
import Object.Account ;

public class SavingAccount extends Account  {
    final double  SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;
    private double phi;

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

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
    public boolean withDraw(double amount) {
        this.setPhi(this.getFeeWithDraw(amount));

        double newBalance=0;
        if(isAccepted(amount)){
            newBalance= this.getBalance()-amount-this.getPhi();
            this.setBalance(newBalance);
            Transaction  transaction = new Transaction(this.getAccountNumber(),amount,untils.getDateTime(),true);
            this.listTransaction.add(transaction);
            return true;
        }else{
            Transaction  transaction = new Transaction(this.getAccountNumber(),amount,untils.getDateTime(),false);
            this.listTransaction.add(transaction);
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
