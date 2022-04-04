package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class ShowsSmallPrefixesLessThan100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number of primes: ");
        int number = scanner.nextInt();
        int count = 0;
        int soNguyenTo = 0;
        System.out.print("sequence of primes less than 100: ");
        while (count < number) {
            boolean flag = true;
            if (soNguyenTo < 2) {
                flag = false;
            } else {
                for (int i = 2; i < soNguyenTo  ; i++) {
                    if (soNguyenTo % i == 0) {
                        flag = false;
                    }
                }
            }
            if (soNguyenTo < 100) {
                if (flag ) {
                    System.out.print(soNguyenTo + ",");
                    count++;
                }
                soNguyenTo++;
            }
        }
    }
}
