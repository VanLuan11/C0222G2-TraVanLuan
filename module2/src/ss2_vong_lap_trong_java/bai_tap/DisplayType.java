package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayType { // hiển thị các loại hình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        String str = "";
        System.out.println("Menu");
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the triangle botton-left");
        System.out.println("3. Draw the triangle top-left");
        System.out.println("0. Exit");
        while (choice != 0) {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("You choice Exit");
                    break;
                case 1:
                    System.out.println("1. Draw the rectangle");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            str += "*";

                        }
                        System.out.println(str);
                        str = "";
                    }
                    break;
                case 2:
                    System.out.println("2. Draw the triangle botton-left");
                    for (int i = 0; i <= 7; i++) {
                        for (int j = 0; j < i; j++) {
                            str += "*";
                        }
                        System.out.println(str);
                        str = "";
                    }
                    break;
                case 3:
                    System.out.println("3. Draw the triangle top-left");
                    for (int i = 7; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            str += "*";
                        }
                        System.out.println(str);
                        str = "";
                    }
                    break;
                default:
                    System.out.println("Has no this select");
            }
        }
    }
}


