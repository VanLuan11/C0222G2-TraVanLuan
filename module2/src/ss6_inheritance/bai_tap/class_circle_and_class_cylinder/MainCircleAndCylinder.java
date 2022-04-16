package ss6_inheritance.bai_tap.class_circle_and_class_cylinder;

import java.util.Scanner;

public class MainCircleAndCylinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String: ");
        String color = scanner.nextLine();

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        Circle circle = new Circle();

        Cylinder cylinder = new Cylinder(radius,color,height);
        System.out.println(cylinder.toString());
        System.out.print("cylindrical: " + cylinder.getCylindrical());
    }





}
