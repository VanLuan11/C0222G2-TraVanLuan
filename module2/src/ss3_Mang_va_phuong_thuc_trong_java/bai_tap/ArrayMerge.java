package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class ArrayMerge { // gop mang
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // cho pt ngẫu nhiên
        int[] arr = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 = new int[arr.length + arr2.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 99);
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = (int) (Math.random() * 99);
            System.out.print(arr2[i] + "\t");
        }
        System.out.println();


//        tự nhập pt
//        int[] arr = new int[5];
//        int[] arr2 = new int[5];
//        int[] arr3 = new int[arr.length + arr2.length];
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("Array 1 element " + i + ":");
//            arr[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print("Array 2 elemets " + i + ":");
//            arr2[i] = scanner.nextInt();
//        }

        int j = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr.length) {
                arr3[i] = arr[i];
            } else {
                arr3[i] = arr2[j];
                j++;
            }
        }
        System.out.print("New array: ");
        for (int a : arr3) {
            System.out.print(a + ",");
        }
    }
}
