package ss4_class_and_oop_java.bai_tap;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter c: ");
        double c = Double.parseDouble(scanner.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        System.out.println(quadraticEquation.Condition());

    }
}
