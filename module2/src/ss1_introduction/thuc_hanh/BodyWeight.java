package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class BodyWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight,height,bmi;
        System.out.println(" You weight (in kg):");
        weight = scanner.nextDouble();
        System.out.println("You height (in m):");
        height = scanner.nextDouble();

        bmi = weight/Math.pow(height,2);
        System.out.printf("a%=20s%s","bmi","Interpretation \n");

        if(bmi <18){
            System.out.printf("a%=20s%s",bmi,"Interpretation \n");
        }else if (bmi<25.0){
            System.out.printf("a%=20s%s","bmi","normal \n");

        }
    }
}
