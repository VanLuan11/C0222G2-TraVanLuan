package ss1_introduction.bai_tap;

import java.util.Scanner;

public class ReadNumbersIntoWords {// chuyển số thành chữ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a digit: ");
        int motSo = scanner.nextInt();
        String chuSo;

        switch (motSo) {
            case 0:
                chuSo = " không";
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
        System.out.print("Số: " + motSo + " Chữ số là: " + chuSo);
    }
}
