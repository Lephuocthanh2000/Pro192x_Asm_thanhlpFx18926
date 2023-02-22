package models;

public class Transaction {
    private String id;
    private  String accountNumber;
    private  double amount;
    private  String time;
    private boolean status;


    public void  historyTransaction(){
        System.out.println("+------------+-------------------------------------+");
        System.out.println("| Lich su giao dich                                 |");
        System.out.println("+------------+-------------------------------------+");

    }
}
