package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a,b,c;

        System.out.println("a: ");
        a = scanner.nextDouble();

        System.out.println("b: ");
        b = scanner.nextDouble();

        System.out.println("c: ");
        c = scanner.nextDouble();
        if(a != 0){
            double solution = (c-b)/a;
            System.out.printf("Equation pass with x = of! \n ", solution);
        }else {
            if ( b== 0 ){
                System.out.printf("The solution is: al x!");
            }
        }
    }
}
