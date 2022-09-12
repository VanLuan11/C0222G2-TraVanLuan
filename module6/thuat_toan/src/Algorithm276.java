import java.util.Scanner;

public class Algorithm276 {
    public static void main(String[] args) {
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
