package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class MaxElements { // tim pt lon nhat trong mang 2 chieu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row element: ");
        int r = scanner.nextInt();
        System.out.print("Enter col elemet: ");
        int c = scanner.nextInt();

        int[][] array = new int[r][c];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 99);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }


        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.print("Munber max: " + max);
    }
}

