package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class RemoveElementFromTheArray { // xóa phàn tử ra khỏi mảng
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length array: "); // nhap do dai
        int size = scanner.nextInt();
        int[]array = new int[size];
        for (int i = 0; i < size; i++) {// phan tu ngau nhien
            array[i] = (int) (Math.random()*99);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");

        }
//        int[] array = new int[10]; // phan tu cho truoc
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (i+1);
//        }
//        System.out.println("My array: ");
//        for (int a: array) {
//            System.out.print(a + ",");
//        }
        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        boolean flag = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(" Index of x: " + index +",");
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;
            System.out.println("New array: ");
            for (int a : array) {
                System.out.print(a + ",");
            }
        } else {
            System.out.print("found not X");
        }
    }
}
