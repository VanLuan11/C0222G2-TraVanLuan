package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class ShowsSmallPrefixesLessThan100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập số lượng số nguyên tố: ");
        int number = scanner.nextInt();
        int count = 0;
        int soNguyenTo = 0;
        System.out.print("Dãy số nguyên tố nhỏ hơn 100: ");
        while (count < number) {
            boolean flag = true;
            if (soNguyenTo < 2) {
                flag = false;
            } else {
                for (int i = 2; i < soNguyenTo - 1; i++) {
                    if (soNguyenTo % i == 0) {
                        flag = false;
                    }
                }
            }
            if (soNguyenTo < 100) {
                if (flag == true) {
                    System.out.print(soNguyenTo + ",");
                    count++;
                }
                soNguyenTo++;
            }
        }
    }
}
