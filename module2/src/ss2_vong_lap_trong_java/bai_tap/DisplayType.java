package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayType { // hiển thị các loại hình
    public static void main(String[] args) {
        int choice = 10;
        String str = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the triangle botton-left");
        System.out.println("3. Draw the triangle top-left");
        System.out.println("0. Exit");


        while (choice != 0) {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            str += " * ";
                        }
                        str += "\n";
                    }
                    System.out.print(str);
                    str = "";
                    break;
                case 2:
                    System.out.println("1. Draw the triangle botton-left");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            str += " * ";
                        }
                        str += "\n";
                    }
                    System.out.print(str);
                    str = "";
                    break;
                case 3:
                    System.out.println("1. Draw the triangle top-left");
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            str += " * ";
                        }
                        str += "\n";
                    }
                    System.out.print(str);
                    str = "";
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("No choice!");
                    break;
            }
        }
    }
}


