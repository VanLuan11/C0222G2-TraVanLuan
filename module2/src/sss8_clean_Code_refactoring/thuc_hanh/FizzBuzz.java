package sss8_clean_Code_refactoring.thuc_hanh;

import java.util.Scanner;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: " );
        int number = scanner.nextInt();
        FizzBuzz.fizzBuzz(number);
        System.out.print(fizzBuzz(number));
    }
}
