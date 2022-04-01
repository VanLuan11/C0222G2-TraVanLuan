package ss1_introduction.thuc_hanh;


import java.util.Scanner;

public class KiemTraNamThuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;

        System.out.println("Enter a year");
        year = scanner.nextInt();
        boolean isLeapYear = false;

        boolean isDivisidleBy4 = year % 4 == 0;
        if (isDivisidleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 100 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }

        }
        if (isLeapYear) {
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}
