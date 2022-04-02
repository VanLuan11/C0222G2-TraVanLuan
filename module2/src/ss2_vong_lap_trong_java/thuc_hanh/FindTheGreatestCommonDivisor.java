package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindTheGreatestCommonDivisor { // tìm ước trung lờn nhất
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a;
        a = input.nextInt();
        a = Math.abs(a);
        System.out.print("Enter b: ");
        int b;
        b = input.nextInt();
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b-a;
            }
        }
        System.out.println("Greatest common factor: " + a);
    }
}
