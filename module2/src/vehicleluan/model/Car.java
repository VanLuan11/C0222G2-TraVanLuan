package vehicleluan.model;

import java.util.Scanner;

public class Car extends Vehicle{
    private int numberOfSeats;
    private String vehicleType;

    public Car() {
    }

    public Car(int numberOfSeats, String vehicleType) {
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public Car(String licensePlates, Manufacturer manufacturer, int yearOfManufacture, String owner, int numberOfSeats, String vehicleType) {
        super(licensePlates, manufacturer, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter seats number: ");
        this.seatsNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter vehicle type: ");
        this.vehicleType = sc.nextLine();
    }
    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
