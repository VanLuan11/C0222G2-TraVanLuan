package ss15_exception_handling_and_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập a: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập b: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập c: ");
            int c = Integer.parseInt(scanner.nextLine());
            try {
                Triangle triangle = new Triangle(a, b, c);
                break;
            } catch (TriangleException e) {
                e.printStackTrace();
            }
        }
    }
}
