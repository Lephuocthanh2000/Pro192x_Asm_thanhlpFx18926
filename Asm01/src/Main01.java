import java.util.Scanner;




public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        do {
            //Hien thi menu
             Asm01.menu();
            // cho nhap chuc nang
            System.out.print("Chuc nang: ");
            String chucNang = sc.next();
            switch (chucNang) {
                case "0": {
                    run = false;
                    System.out.println("Hen gap lai !!!");
                    break;
                }
                case "1": {
                    //kiem tra
                    int soKyTu  = 0;
                    do {
                        System.out.println("Do kho ma xac thuc: ");
                        System.out.println("1. EASY ");
                        System.out.println("2. HARD");
                        System.out.print("Chon do kho ma xac thuc: ");
                        int doKho = sc.nextInt();

                        switch (doKho) {
                            case 1: {
                                soKyTu = 3;
                                break;
                            }
                            case 2: {
                                soKyTu = 6;
                                break;
                            }
                            default: {
                                soKyTu = 0;
                                System.out.println("Nhap khong dung yeu cau, vui long nhap lap lai !!!");
                                break;
                            }
                        }
                    }while(soKyTu == 0);
                    if (Asm01.checkSecurity(soKyTu) == true) {
                        // Nhap can cuoc cong dan
                        String cccd = Asm01.showCCCD();
                        int selection;
                        if (Asm01.checkCCCD(cccd) == true) {
                            int check = 0;
                            do {
                                selection = Asm01.menuChucNang();
                                switch (selection) {
                                    case 1: {
                                        // check kiem tra noi sinh
                                        Asm01.checkAddress(cccd);
                                        break;
                                    }
                                    case 2: {
                                        // check kiem tra tuoi, gioi tinh
                                        Asm01.checkBirthDay(cccd);
                                        break;
                                    }
                                    case 3: {
                                        //  kiem tra so ngau nhien
                                        Asm01.checkLastSixNumberCCCD(cccd);
                                        break;
                                    }
                                    case 0: {
                                        //thoat
                                        check++;
                                        System.out.println("Hen gap lai !!!");
                                        break;

                                    }
                                    default: {
                                        check = 0;
                                    }
                                }

                            } while (check == 0);
                        } else {
                            System.out.println("CCCD khong dung. Xin vui long thu lai");
                        }
                    } else {
                        System.out.println("Ma xac thuc khong dung. Xin vui long thu lai");
                    }
                    break;
                }
                default: {
                    System.out.println("Nhap khong dung theo yeu cau, moi ban nhap lai !!!");
                }
            }
        }while(run == true) ;


    }
}