package ss5_access_modifier_static_method_static_property.bai_tap.Circle;

import java.util.Scanner;

public class MainCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Area: " + circle.getArea());

    }
}
