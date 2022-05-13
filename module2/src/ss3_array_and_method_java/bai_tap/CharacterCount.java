package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class CharacterCount {// đếm số lần ký tự

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "anhtai tainang";
        System.out.print("Enter char count: ");
        char kyTu = scanner.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (kyTu == str.charAt(i)) {
                count++;
            }
        }
        System.out.print("Total char count: " + count);
    }
}
