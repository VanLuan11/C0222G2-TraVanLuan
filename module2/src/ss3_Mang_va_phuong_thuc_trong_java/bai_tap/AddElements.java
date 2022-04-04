package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class AddElements { // them phan tu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 99);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter index: ");
        int index = scanner.nextInt();

        if (index <= -1 || index >= arr.length - 1 ){
            System.out.print(" cannot add");
        }else{
            for (int i = arr.length -1 ; i > index ; i--) {
                arr[i] = arr[i-1];
            }
            arr[index] = x;
            System.out.print("New array: ");
            for ( int a : arr){
                System.out.print(a+ ",");
            }
        }
    }
}
