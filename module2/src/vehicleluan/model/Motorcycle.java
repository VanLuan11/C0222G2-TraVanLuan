package vehicleluan.model;

import java.util.Scanner;

public class Motorcycle extends Vehicle{
    private double wattage;

    public Motorcycle() {
    }

    public Motorcycle(String licensePlates, Manufacturer manufacturer, int yearOfManufacture, String owner, double wattage) {
        super(licensePlates, manufacturer, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter wattage (HP): ");
        this.wattage = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "wattage=" + wattage +
                '}';
    }
}
