package homework.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Vehicle {
    protected int seatsNumber;
    private String licensePlates;
    private Manufacturer manufacturer;
    private int yearOfManufacture;
    private String owner;

    public Vehicle() {

    }

    public Vehicle(String licensePlates, Manufacturer manufacturer, int yearOfManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sea of control: ");
        this.licensePlates = scanner.nextLine();
        this.manufacturer = this.choiceManufacturer();
        System.out.println("Enter year of manufacture: ");
        this.yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter owner: ");
        this.owner = scanner.nextLine();
    }

    public Manufacturer choiceManufacturer() {
        Scanner sc = new Scanner(System.in);
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList.add(new Manufacturer(1, "TOYOTA", "Japan"));
        manufacturerList.add(new Manufacturer(3, "FUSO", "Japan"));
        manufacturerList.add(new Manufacturer(5, "PIAGGIO", "Italy"));


        System.out.println("CHOICE MANUFACTURER ");
        int choice;
        do {
            for (int i = 0; i < manufacturerList.size(); i++) {
                System.out.println((i + 1) + ". " + manufacturerList.get(i).getName());
            }
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice < manufacturerList.size()) {
                return manufacturerList.get(choice - 1);
            } else {
                System.out.println("CHOICE AGAIN");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Biển kiểm soát=" + licensePlates +
                ", Tên hãng sản xuất='" + manufacturer + '\'' +
                ", Năm sản xuất='" + yearOfManufacture + '\'' +
                ", Chủ sở hữu='" + owner + '\'' +
                '}';
    }
}
