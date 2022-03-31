package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Which month that you count days?");
        int month = sc.nextInt();
        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = "28 or 29 ";
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "30";
            case 4:
            case 6:
            case 9:
                daysInMonth = "31";
                break;
            default:
                daysInMonth = "";
        }
        if (daysInMonth != "") {
            System.out.printf("The month '%d' has %s days" , month, daysInMonth);
        }
    }
}
