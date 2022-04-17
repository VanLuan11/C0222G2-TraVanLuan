package ss11_dsa_stack_queue.bai_tap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InvertedElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        // đảo mảng
//        System.out.print("nhập số: ");
//        int number = Integer.parseInt(scanner.nextLine());
        int[] arrayNumber = {1,2,3,4,5,6,7};
        for (int a: arrayNumber) {
            System.out.print(a);
        }
        System.out.println("---------------");

        for (int i = 0; i < arrayNumber.length; i++) {
            stack.push(arrayNumber[i]);
        }

        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = stack.pop();
        }

        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i]);
        }
        System.out.println();

//         đảo chuỗi
        System.out.println("Nhập chuỗi muốn đảo: ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            stack2.push(str.charAt(i) + "");
        }
        System.out.println("Sau khi đảo");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack2.pop());

        }
    }
}
