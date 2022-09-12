import java.util.Scanner;

public class Algorithm275 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 7, 1};
        int sum1,sum2,sum = 0,max = arr[0],min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];

        }
        sum1 = sum - max;
        sum2 = sum - min;
        System.out.println(sum1);
        System.out.println(sum2);

    }
}
