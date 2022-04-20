package ss14_sort_algorithm.bai_tap;

import java.util.Arrays;

public class SettingInsertionSort {
    public static void  insertSort (int [] array) {
        for (int  i =  1 ; i < array.length; i++) {
            int  temp = array[i];
            int  j = i - 1 ;
            for  (; j >= 0 && array[j] > temp; j--) {
                // Moves the value greater than temp back by one unit
                array [j + 1] = array [j];
            }
            array [j + 1] = temp;
        }
        System.out.println(Arrays.toString(array) + "insertSort");
    }
}
