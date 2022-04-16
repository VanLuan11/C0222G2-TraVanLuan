package ss11_dsa_stack_queue.bai_tap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InvertedElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Trước khi đảo");
        for (int number: array) {
            System.out.print(number);
        }
        System.out.println();
        for (int i = array.length-1; i >= 0  ; i--) {
            stack.push(array[i]);
        }
        System.out.println("Sau khi đảo");
        for (int nunber2: stack) {
            System.out.print(nunber2);

        }
    }
}
