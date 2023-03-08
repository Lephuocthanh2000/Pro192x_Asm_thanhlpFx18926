
import java.util.Random;
import java.util.Scanner;


public class Asm01 {
    public static Scanner sc = new Scanner(System.in);
    // function Menu
    public static void menu(){
        final String AUTHOR = "THANHLPfx18926";
        final String VERSION ="1.0.0";
        System.out.println("+---------------+------------------+-----------------+");
        System.out.println("| NGAN HANG SO  |  "+ AUTHOR +"@"+VERSION+ "        |" );
        System.out.println("+---------------+------------------+-----------------+");
        System.out.println("| 1. NHAP CCCD                                       |" );
        System.out.println("| 0. THOAT                                           |" );
        System.out.println("+---------------+------------------+-----------------+");

    }
    // function Menu chuc nang
    public static  int menuChucNang(){

        System.out.println("| 1. Kiem tra noi sinh ");
        System.out.println("| 2. Kiem tra tuoi, gioi tinh ");
        System.out.println("| 3. Kiem tra so ngau nhien ");
        System.out.println("| 0. Thoat ");
        System.out.print("Chuc nang: ");
        int selection = sc.nextInt();
        return selection;
    }
    // random 1 so
    public static int randomNumber(int min, int max) {
        Random generator = new Random();
        return generator.nextInt((max - min) + 1) + min;
    }
    // Tao ma xac thuc
    public static String maXacThuc(int numberOfCharactor){
        final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        final String alphaUpperCase = alpha.toUpperCase(); // A-Z
        final String digits = "012345678901234567890123456789"; // 0-9
        final String specials = "~=+%^*/()[]{}/!@#$?|";
        final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        final String ALL = alpha + alphaUpperCase + digits + specials;

        StringBuilder maXacThuc = new StringBuilder();
        if(numberOfCharactor == 3){
            /**
             * Random string with 0-9
             */
            for (int i = 0; i < numberOfCharactor; i++) {
                int number = randomNumber(0, digits.length() - 1);
                char chuoi = digits.charAt(number);
                maXacThuc.append(chuoi);
            }
        }else {
            /**
             * Random string with a-z A-Z 0-9, not included special characters
             */
            for (int i = 0; i < numberOfCharactor; i++) {
                int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
                char chuoi = ALPHA_NUMERIC.charAt(number);
                maXacThuc.append(chuoi);
            }
        }
        return maXacThuc.toString();
    }
    // function check Security
    public  static  boolean checkSecurity(int soKyTu){
        String maXacThuc = maXacThuc(soKyTu);
        System.out.print("Ma xac thuc : " + maXacThuc);
        // ma xac nhan va kiem tra
        System.out.print("\nNhap ma xac thuc: ");
        String maXacNhan = sc.next();
        if(maXacNhan.equals(maXacThuc))
            return true;
        else
            return  false;
    }
    // function show CCCD
    public static String showCCCD(){
        System.out.print("Nhap can cuoc cong dan: ");
        String cccd = sc.next();
        return cccd;

    }
    // function check CCCD
    public  static  boolean checkCCCD(String cccd){
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
    // function show Address
    public  static  void checkAddress(String cccd){
        // mang danh sach cac tinh
        int[]  maDanhSachTinh={1,2,4,6,8,10,11,12,14,15,17,19,20,22,24,25,26,27,30,31,33,34,35,36,37,38,40,42,44,45,46,48,49,51,52,54,56,58,60,
                62,64,66,67,68,70,72,74,75,77,79,80,82,83,84,86,87,89,91,92,93,94,95,96};
        String[] danhSachTinh = {"Ha Noi","Ha Giang","Cao Bang","Bac Kan"," Tuyen Quang","Lao Cai","Dien Bien","Lai Chau",
                "Son La","Yen Bai","Hoa Binh","Thai Nguyen","Lang Son","Quang Ninh","Bac Giang","Phu Tho","Vinh Phuc","Bac Ninh",
                "Hai Duong","Hai Phong","Hung Yen","Thai Binh","Ha Nam","Nam Dinh","Ninh Binh","Thanh Hoa","Nghe An","Ha Tinh","Quang Binh",
                "Quang Tri","Thua Thien Hue","Da Nang","Quang Nam","Quang Ngai","Binh Dinh","Phu Yen","Khanh Hoa","Ninh Thuan","Binh Thuan","Kon Tum","Gia Lai",
                "Dak Lak","Dak Nong","Lam Dong","Binh Phuoc","Tay Ninh","Binh Duong","Dong Nai","Ba Ria- Vung Tau","Ho Chi Minh",
                "Long An","Tien Giang","Ben Tre","Tra Vinh","Vinh Long","Dong Thap","An Giang","Kien Giang","Can Tho","Hau Giang","Soc Trang","Bac Lieu","Ca Mau"};
        // xu ly chuoi cccd
        String noiSinh = String.copyValueOf(cccd.toCharArray(),0,3);
        int maTest = Integer.parseInt(noiSinh);
        int manoiSinh =0 ;
        for (int i =0;i<maDanhSachTinh.length;i++){
            if(maDanhSachTinh[i]==maTest){
                manoiSinh=i;
                break;
            }
        }
        // in thong tin noi sinh ra man hin
        System.out.println("Noi sinh: "+danhSachTinh[manoiSinh]);

    }
    // function show Birthday
    public  static  void checkBirthDay  (String cccd){
        // get gioi tinh
        String gioiTinh ;
        int maGioiTinh = Integer.parseInt(String.copyValueOf(cccd.toCharArray(),3,1));
        if (maGioiTinh == 0 || maGioiTinh%2 ==0){
            gioiTinh ="Nam";
        }else {
            gioiTinh ="Nu";
        }
        // nam sinh
        //086200007406
        int namSinh = Integer.parseInt(String.copyValueOf(cccd.toCharArray(),4,2));
        if (maGioiTinh < 2 ){
            namSinh = 1900 +namSinh;
        }else if(maGioiTinh >1 && maGioiTinh<4){
            namSinh = 2000 +namSinh;
        }else if (maGioiTinh >3 && maGioiTinh <6){
            namSinh = 2100 +namSinh;
        }else if (maGioiTinh>5 && maGioiTinh < 8){
            namSinh = 2200 +namSinh;
        }else if(maGioiTinh>7 && maGioiTinh <10){
            namSinh = 2300 +namSinh;
        }
        System.out.println("Gioi tinh: "+gioiTinh+" | "+namSinh);
    }
    // function check last 6
    public static void checkLastSixNumberCCCD(String cccd){
        //086200007406
        String lastSixNumber = String.copyValueOf(cccd.toCharArray(),6,6);
        System.out.println("So ngau nhien: "+lastSixNumber);
    }


}