package sss8_clean_Code_refactoring.thuc_hanh;

import java.util.Scanner;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        int radius = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter height: ");
        int height = Integer.parseInt(scanner.nextLine());
        Cylinder.getVolume(radius,height);
        System.out.println("Perimeter: " + Cylinder.getPerimeter(radius));
        System.out.println("BaseArea: "+Cylinder.getBaseArea(radius));
        System.out.println("Volum: " + Cylinder.getVolume(radius,height));


    }
}
