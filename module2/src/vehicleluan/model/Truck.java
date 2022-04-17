package vehicleluan.model;

import java.util.Scanner;

public class Truck extends Vehicle{
    private double tonnage;

    public Truck() {

    }

    public Truck(String licensePlates, Manufacturer manufacturer, int yearOfManufacture, String owner, double tonnage) {
        super(licensePlates, manufacturer, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter tonnage (T): ");
        this.tonnage = Integer.parseInt(sc.nextLine());
    }



    @Override
    public String toString() {
        return "Truck{" +
                "tonnage=" + tonnage +
                '}';
    }
}
