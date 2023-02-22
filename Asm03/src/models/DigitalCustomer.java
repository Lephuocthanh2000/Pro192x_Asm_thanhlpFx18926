package models;
import Object.Customer;
import Object.Account;
public class DigitalCustomer extends Customer {
    public DigitalCustomer() {
        super();
    }

    public DigitalCustomer(String name, String customerId, Account newAccount) {
        super(name, customerId, newAccount);
    }

    public boolean withDraw(String accountNumber, double amount) {
        /*
            check accountNumber có tồn tại hay không
            Nếu tồn tại trả về true - ngược lại trả về false
         */
        if (this.checkAccountExits(accountNumber)) {
            for (Account account : this.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    if (account.getLoaiTaiKhoan().equals("LoanAccount")) {
                        account = new LoanAccount();
                        account.withDraw(amount);
                    } else {
                        account = new SavingAccount();
                        account.withDraw(amount);
                    }
                    return  true;

                }
            }
        }
        return false;
    }

}

