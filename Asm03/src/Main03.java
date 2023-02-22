import Object.Account;
import Object.Customer;
import models.DigitalBank;
import models.LoanAccount;
import models.SavingAccount;

import java.util.Scanner;

public class Main03 {

    private  static Scanner sc = new Scanner(System.in);
    //khai báo
    private  static DigitalBank activeBank = new DigitalBank();
    private  static String  CUSTOMER_ID = "086200007406";
    private  static String  CUSTOMER_NAME = "ThanhlpFX18926";

    private  static Customer customer;
    // chức năng 1
    private static  void showCustomer(String customerId){
        customer = activeBank.getCustomerById(customerId);
        if(customer!=null){
            customer.displayInformation();
        }else {
            System.out.println("Khong ton tai khach hang nay trong he thong !!!");
        }

    }
    // chức năng 2
    private  static boolean  addSavingAccount(String customerId){
        Customer customer = activeBank.getCustomerById(customerId);
        if(customer!=null){
            Account newAccount = new Account();
            newAccount.inputAccount();
            for (Account account: customer.getAccounts()){
                if (account.getAccountNumber().equals(newAccount.getAccountNumber())){
                    System.out.println("Tai khoan da ton tai !!!");
                }else{
                    customer.addAccount(new SavingAccount(newAccount.getAccountNumber(),newAccount.getBalance()));
                    return true;
                }
            }

        }else {
            System.out.println("Khong ton tai khach hang nay trong he thong !!!");
        }
        return false;
    }
    // chức năng 3
    private  static boolean  addLoanAccount(String customerId,Account newAccount){
      customer = activeBank.getCustomerById(customerId);
        if(customer!=null){
            newAccount.inputAccount();
            for (Account account: customer.getAccounts()){
                if (account.getAccountNumber().equals(newAccount.getAccountNumber())){
                    System.out.println("Tai khoan da ton tai !!!");
                }else{
                    customer.addAccount(new LoanAccount(newAccount.getAccountNumber(),newAccount.getBalance()));
                    return true;
                }
            }

        }else {
            System.out.println("Khong ton tai khach hang nay trong he thong !!!");
        }
        return false;
    }
    /*
        chức năng 4
        - chuc nang rut tien
        - tham so truyen vao la customerId, tài khoan cần rút
        - kieu du lieu tra ve boolean.
     */
    private  static boolean  withDrawAccount( String customerId){
        customer = activeBank.getCustomerById(customerId);
        if(customer!=null){
            boolean check = true;
            System.out.print("nhap so tai khoan: ");
            String customerAccount = sc.next();
            for (Account account: customer.getAccounts()){
                if (account.getAccountNumber().equals(customerAccount)){
                    check=false;
                    System.out.print("Nhập số tiền cần rút: ");
                    double money = sc.nextDouble();
                    if(account.getLoaiTaiKhoan().equals("LoanAccount")){
                        account = new LoanAccount(account.getAccountNumber(),account.getBalance());
                        account.withDraw(money);
                        account.log(money);
                        customer.getAccounts();


                    }else {
                        account = new SavingAccount();
                        account.withDraw(money);
                        account.log(money);
                    }
                    return true;
                }
            }
            if(check){
                System.out.println("Tai khoan khong ton tại trong he thong !!!");
            }

        }else {
            System.out.println("Khong ton tai khach hang nay trong he thong !!!");
        }
        return false;
    }
    //chức năng 5
    /*

     */
    private  static  void  historyTransaction (String customerId){

    }

//      - hàm menu in ra menu cho chuong trinh
    private   static  void menu(){
        final String AUTHOR = "THANHLPfx18926";
        final String VERSION ="3.0.0";
        System.out.println("+---------------+------------------+-----------------+");
        System.out.println("| NGAN HANG SO  |  "+ AUTHOR +"@"+VERSION+ "         |" );
        System.out.println("+---------------+------------------+-----------------+");
        System.out.println("| 1. Thong tin khach hang                            |" );
        System.out.println("| 2. Them tai khoan Saving                           |" );
        System.out.println("| 3. Them tai khoan Loan                             |" );
        System.out.println("| 4. Rut tien                                       |" );
        System.out.println("| 5. Lich su giao dich                              |" );
        System.out.println("| 0. Thoat                                           |" );
        System.out.println("+---------------+------------------+-----------------+");
    }


    // main
    public static void main(String[] args) {
        activeBank.addCustomer(new Customer(CUSTOMER_ID,CUSTOMER_NAME,new Account()));
        boolean stop =false;
        do {
            menu();
            System.out.print("Chuc nang: ");
//            try {
            int selection = sc.nextInt();
            switch (selection){
                case 0:{
                    // Exit
                    stop =true;
                    System.out.println("Tam biet quy khach - hen gap lai !!!");
                    break;
                }
                case 1:{
                    //Thông tin khách hàng
                    showCustomer(CUSTOMER_ID);
                    break;
                }
                case 2:{
//                    account = new SavingAccount();
                    // Thêm tài khoản saving
                    addSavingAccount(CUSTOMER_ID);
                    break;
                }
                case 3:{
                    // thêm tài khoản Loan
                     Account account = new LoanAccount();
                     addLoanAccount(CUSTOMER_ID,account);
                    break;
                }
                case 4:{
                    //Rút tiền
                        /*
                        Cho người dùng nhập số tiền cần rút
                            Đối với tài khoản Savings
                            Số tiền rút phải lớn hơn hoặc bằng 50.000đ
                            Số tiền 1 lần rút không được quá 5.000.000đ đối với tài khoản thường, và không giới hạn đối với tài khoản Premium.
                            Số dư còn lại sau khi rút phải lớn hơn hoặc bằng 50.000đ
                            Số tiền rút phải là bội số của 10.000đ
                            Đối với tài khoản Loan
                            Hạn mức không được qúa giới hạn 100.000.000đ
                            Phí cho mỗi lần giao dịch là 0.05 trên số tiền giao dịch đối với tài khoản thường và 0.01 trên số tiền giao dịch đối với tài khoản Premium.
                            Hạn mức còn lại sau khi rút tiền không được nhỏ hơn 50.000đ
                         */

                    withDrawAccount(CUSTOMER_ID);
                    break;
                }
                case  5:{

                    break;
                }
                default:{
                    // Hien thi lai menu
                    System.out.println("Nhap khong dung ⛔⛔⛔");
                }
            }
        }while (!stop);

    }
}