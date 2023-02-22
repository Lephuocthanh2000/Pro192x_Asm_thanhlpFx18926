package Object;



import interfaces.WithDraw;
import models.LoanAccount;
import models.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User   {
    private List <Account> accounts ;

    public Customer() {
       this.accounts = null;
    }
    public Customer(String customerId,String name,  Account newAccount) {
        super( customerId,name);
       this.accounts = new ArrayList<>();
       this.accounts.add(newAccount);
    }
    // method
    public String isPremium(){

        if(this.accounts != null){
            for (Account account : this.accounts) {
                if (account.isPremium())
                    return "Premium";
            }
        }

        return  "Normal";
    }

    // add Account
    public void addAccount (Account newAccount){
        int test = 0;
        for (Account account: this.accounts){
            if((account.getAccountNumber()).equals(newAccount.getAccountNumber())){
                test +=1;
            }
        }
        if( test ==0 ) {

            this.accounts.add(newAccount);
            this.accounts.isEmpty();
        }
    }
    // get balance
    public double getBalance(){
        double sumBalance = 0.00;
        if(!this.accounts.isEmpty()){
            for(Account account: this.accounts){
                sumBalance += account.getBalance();
            }
        }
        return  sumBalance;
    }
    // display information
    public  void displayInformation(){
        if(this.accounts != null){
            int sstAccount = 0;
            System.out.println(this.getCustomerId()+" | "+this.getName()+" | "+this.isPremium()+" | "+this.getBalance()+ " đ");
            if(!(this.accounts.isEmpty())){
                for (Account account: this.accounts){
                    if(!account.getAccountNumber().equals(" ")) {
                        sstAccount += 1;
                        System.out.println(sstAccount + "  " + account.getAccountNumber() + " | " + account.getLoaiTaiKhoan() + " | " + account.getBalance() + " đ");
                    }
                }
            }
        }else{
            System.out.println(this.getCustomerId()+" | "+this.getName()+" |            "+" đ");

        }

    }
    // check Account exits
    public boolean checkAccountExits(String accountNumber){
        for(Account account : this.getAccounts()){
            if(account.getAccountNumber().equals(accountNumber)){
                return true;
            }
        }
        return false;
    }
    //getter and setter
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean withDraw(String accountNumber, double amount) {
        return false;
    }
}
