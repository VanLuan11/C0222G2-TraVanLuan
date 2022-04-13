package sss8_clean_Code_refactoring.thuc_hanh;

import java.util.Scanner;

public class Calculator {
        public static final char ADDITION = '+';
        public static final char SUBTRACTION = '-';
        public static final char MULTIPLICATION = '*';
        public static final char DIVISION = '/';
        public static int calculate(int firstOperand, int secondOperand, char operator) {
            switch (operator) {
                case ADDITION:
                    return firstOperand + secondOperand;
                case SUBTRACTION:
                    return firstOperand - secondOperand;
                case MULTIPLICATION:
                    return firstOperand * secondOperand;
                case DIVISION:
                    if (secondOperand != 0)
                        return firstOperand / secondOperand;
                    else
                        throw new RuntimeException("Can not divide by 0");
                default:
                    throw new RuntimeException("Unsupported operation");
            }
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter firstOperand: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter secondOperand: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter char: ");
        char c = scanner.nextLine().charAt(0);
        Calculator.calculate(a, b, c);
        System.out.println(Calculator.calculate(a, b, c));
    }
}
