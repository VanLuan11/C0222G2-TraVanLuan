package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DiagonalLineMain {
    public static void main(String[] args) {// tính đường chéo chính
        Scanner scanner = new Scanner(System.in);
        
//        // nhập dòng và cột
//        System.out.print("Enter Row: ");
//        int r = scanner.nextInt();
//        System.out.print("Enter Col: ");
//        int c = scanner.nextInt();

        // cho dòng với cột sẵn
        int[][] arr = new int[4][4];

        //tạo và đưa các pt vào mảng
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 99);
            }
        }

        //đưa ra mảng
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        // tính tổng đường chéo hình vuông
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) { // tính đường chéo hình vuông là i sẽ bằng j
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Tolat diagonal line: " + sum);
    }
}
