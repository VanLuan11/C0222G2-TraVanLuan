package ss3_array_and_method_java.thuc_hanh;

import java.util.Scanner;

public class CountingStudentsPassingExams { // dem so sinh vien thi do
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int size;
       int[] array;
        do {
            System.out.print("Enter array length: ");
            size = scanner.nextInt();
            if(size > 30)
                System.out.print("no array length more than 30");
        }while (size > 30);

        array = new int[size];
        int i =0;
        while ( i < array.length){
            System.out.print("Enter mark student " + (i+1) + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        int count = 0;
        System.out.print("list mark student: " );
        for (int j = 0; j < array.length ; j++) {
            System.out.print(array[j] + "," );
            if(array[j] >=5 && array[j] <= 10){
                count++;
            }
        }
        System.out.print(" \n Amount student passed: " + count);
    }
}
