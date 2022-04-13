import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập số lượng phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println(Test.solution(arr));
    }

    public static boolean solution(int[] arr) {
        boolean flag = false;
        if (arr.length <= 2) {
            return false;
        } else {
            for (int i = 1; i < arr.length - 1; i++) {
                int firstSum = 0;
                int secondSum = 0;
                for (int j = 0; j < i; j++) {
                    firstSum += arr[j];
                }
                for (int j = (i + 1); j < arr.length; j++) {
                    secondSum += arr[j];
                }
                if (firstSum == secondSum) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
