package bai_thi.common;


import java.util.Scanner;

public class Exception {
    public static Integer exception(Integer integer) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                integer = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        return integer;
    }
}
