package ss1_introduction.bai_tap;

import java.util.Scanner;

public class ConvertTheForeignCurrency { // chuyển đổi tiền tệ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the amount you want to convert Vnd: ");

        double vnd = 23000;
        double usd;
        usd = sc.nextDouble();
        double quyDoi = usd *23000;
        System.out.print( quyDoi + "Vnđ" );
    }
}
