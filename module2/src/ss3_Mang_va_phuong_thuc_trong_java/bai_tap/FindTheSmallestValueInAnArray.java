package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class FindTheSmallestValueInAnArray { // tìm số nhỏ nhất
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        System.out.print("enter array length: ");
        size = scanner.nextInt();

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter elements " + (i + 1) + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("array element: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + ",");
        }
        int min = array[0];
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;

            }
        }
        System.out.print("smallest element : " + min + " vị trí: " + index);
    }
}
