import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        int[] arr = {1, 6, 5, 2, 1, 5, 2, 4, 3, 3};
        int sum = 0;
        int num = 6;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == num) {
                    System.out.println("Vị trí i: " + i + "" + " Vị trí j:" + j);
                }
            }
        }
//        int[] arr = {2, 5, 5, 7, 1};
//        int sum1,sum2,sum = 0,max = arr[0],min = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//            if (min > arr[i]) {
//                min = arr[i];
//            }
//            sum += arr[i];
//
//        }
//        sum1 = sum - max;
//        sum2 = sum - min;
//        System.out.println(sum1);
//        System.out.println(sum2);



        Scanner sc = new Scanner(System.in);
        int num1, num2, reversed = 0;
        System.out.print("Nhập vào số cần đảo ngược: ");
        num1 = sc.nextInt();

        while (num1 != 0) {
            int digit = num1 % 10;
            System.out.println(digit);
            reversed = reversed * 10 + digit;
            num1 /= 10;
            System.out.println(num1);
        }
        System.out.print(reversed);

    }
}
