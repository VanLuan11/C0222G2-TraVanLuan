package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class SumOfNumbersInColumn {
    public static void main(String[] args) {// tính tổng cột
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        int r = scanner.nextInt();
        System.out.print("Enter col: ");
        int c = scanner.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter element Row " + i + " Col " + j + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Enter Row: ");
        int index = scanner.nextInt();

        System.out.print("Enter Col: ");
        int index2 = scanner.nextInt();
        int sumRow = 0;
        int sumCol = 0;
        for (int i = 0; i < arr.length; i++) {
            sumRow += arr[i][index]; // tinh dong
            sumCol += arr[index2][i];// tinh cot
        }

        System.out.print("Total Row: " + index + " Total Row: " + sumRow + "\n" + "Total Row: " + index2 + " Total Col: " + sumCol);
    }
}
