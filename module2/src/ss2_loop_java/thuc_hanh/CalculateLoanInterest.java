package ss2_loop_java.thuc_hanh;

import java.util.Scanner;

public class CalculateLoanInterest { // tính tiền lãi cho vay
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         double money = 1.0;
         int month = 1;
         double interestRate = 1.0; // lai suat

        System.out.print("Enter investment amount: ");
        money = scanner.nextDouble();

        System.out.print("Enter number of months: ");
        month = scanner.nextInt();

        System.out.print("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();

        double totalInterest = 0; //lai suat nhan dc
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate/100)/12 * month;
            
        }
        System.out.println("Total of interest: " +  totalInterest );

    }
}
