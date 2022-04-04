package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfNumbersInColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        int r = scanner.nextInt();
        System.out.print("Enter col: ");
        int c = scanner.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Element Row" + i + ":" + "\n" + "Col" + j + ":");
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("");
        }
        System.out.println("Enter col: ");
        int index = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                sum += arr[index][j];
                index=i;
            }
        }
        System.out.print("vi tri cong: " + index + "tong: " + sum);
    }
}
