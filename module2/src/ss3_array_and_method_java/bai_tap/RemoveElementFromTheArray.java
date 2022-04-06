package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class RemoveElementFromTheArray { // xóa phàn tử ra khỏi mảng
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length array: "); // nhap do dai
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {// phan tu ngau nhien
            array[i] = (int) (Math.random() * 99);
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
        System.out.print("Enter x: ");
        int x = scanner.nextInt(); // x cần xóa

        boolean flag = false; // ko có trong mảng
        int index = 0;
        for (int i = 0; i < array.length; i++) { // xét xem phần tử đó có trong mảng ko
            if (x == array[i]) {
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(" Index of x: " + index + ",");
            //duyệt mảng từ vị trí cần xóa đến cuối mảng
            for (int i = index; i < array.length -1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0; // thêm 0 vào cuối mảng
            System.out.println("New array: ");
            for (int a : array) {
                System.out.print(a + ",");
            }
        } else {
            System.out.print("found not X");
        }
    }
}
