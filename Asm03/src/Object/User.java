package Object;

import java.util.Scanner;

public class User {
    protected String name;
    protected String customerId;

    private  static  final  Scanner sc = new Scanner(System.in);
    //contrustor
    public  User(){
        this.customerId = "123456789000";
        this.name = "Name User";

    }
    public User( String customerId,String name) {

                this.name = name;
                this.customerId = customerId;


    }
    public  void inputUser (){
        // nhập tên người dùng

        System.out.println("Nhap ten khach hang: " );
        this.setName(sc.next());
        sc.nextLine();
        // nhập cccd
        System.out.println("Nhap so CCCD: ");
        String inputCCCD = sc.next();
        // kiểm tra thành công thì set cccd cho người dùng
        this.setCustomerId(inputCCCD);

    }
    // function check CCCD
    private   static  boolean checkcustomerId(String cccd){
        // kiem tra do dai cccd
        int lengthCCCD= cccd.length();
        // kiem tra moi ki tu co phai la so khong
        boolean testCCCD =true;
        for (char c : cccd.toCharArray())
        {
            if (!Character.isDigit(c))
                testCCCD= false;
        }
        if(testCCCD ==true && lengthCCCD ==12){
            return true;
        }else
            return false;
    }
    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        boolean testCCCD = checkcustomerId(customerId);
        do{
            if(!testCCCD){
                System.out.println(" so CCCD khong hop le. Moi ban nhap lai !!!");
                System.out.println("Nhap so CCCD: ");
                customerId = sc.next();
                testCCCD = checkcustomerId(customerId);
            }
        }while(!testCCCD);
        // kiểm tra thành công thì set cccd cho người dùng
        this.customerId = customerId;
    }
}
