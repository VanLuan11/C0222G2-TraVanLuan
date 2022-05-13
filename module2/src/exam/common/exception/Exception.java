package exam.common.exception;

import java.util.Scanner;

public class Exception {
    static Scanner scanner = new Scanner(System.in);
    public static Integer getInteger(Integer integer){
        boolean check = true;
        while (check){
            try {
               integer = Integer.parseInt(scanner.nextLine());
               check = false;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());;
            }
        }
        return integer;
    }
}
