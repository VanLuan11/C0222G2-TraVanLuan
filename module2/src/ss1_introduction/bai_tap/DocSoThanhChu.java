package ss1_introduction.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhập 1 chữ số");
        int motSo = scanner.nextInt();
        String chuSo;

        switch (motSo) {
            case 0:
                chuSo = " ";
                break;
            case 1:
                chuSo = " mot";
                break;
            case 2:
                chuSo = " hai";
                break;
            case 3:
                chuSo = " ba";
                break;
            case 4:
                chuSo = " bon";
                break;
            case 5:
                chuSo = " nam";
                break;                        
            case 6:
                chuSo = " sau";
                break;
            case 7:
                chuSo = " bay";
                break;
            case 8:
                chuSo = " tam";
                break;
            case 9:
                chuSo = " chin";
                break;
            default:
                chuSo = "không có";
        }
            System.out.print("Số: " + motSo + " Chữ: " + chuSo);
    }
}
