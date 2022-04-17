package vehicleluan.service;

import ss10_dsa_list.bai_tap.array_list.ArrayList;
import vehicleluan.model.*;

import java.util.List;
import java.util.Scanner;

public class VehicleServiceImpl implements VehicleService{
    List<Vehicle> vehicle1 = new ArrayList<>();

    {
        Manufacturer toyota = new Manufacturer(1, "TOYOTA", "Japan");
        Manufacturer chevrolet = new Manufacturer(2, "CHEVROLET", "USA");
        Manufacturer fuso = new Manufacturer(3, "FUSO", "Japan");
        Manufacturer daewoo = new Manufacturer(4, "DAEWOO", "Korea");
        Manufacturer piaggio = new Manufacturer(5, "PIAGGIO", "Italy");
        Manufacturer harley = new Manufacturer(6, "Harley Davidson", "USA");

        Vehicle car = new Car("74F1-12345", toyota, 2005, "Le Thanh Hau", 4, "Police");
        Vehicle car1 = new Car("74F1-15652", chevrolet, 2015, "Tran Van Hoan", 20, "Bus");
        Vehicle truck = new Truck("43F1-2345", fuso, 1955, "Le Van Tai", 1500);
        Vehicle truck1 = new Truck("92F1-96452", daewoo, 1985, "Tra Van Luan", 1100);
        Vehicle moto = new Motorcycle("74F1-21358", piaggio, 2003, "Tran Thuan", 110);
        Vehicle moto1 = new Motorcycle("38F1-84235", harley, 2018, "Le Van Phuc", 80);

        vehicle1.add(car);
        vehicle1.add(car1);
        vehicle1.add(truck);
        vehicle1.add(truck1);
        vehicle1.add(moto);
        vehicle1.add(moto1);
    }

    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = true;
        do {
            System.out.println("---------- DISPLAY VEHICLES MENU ----------");
            System.out.println("1. Display car" + "\n" +
                    "2. Display truck" + "\n" +
                    "3. Display motorcycle" + "\n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---------- CAR ----------");
                    for (Vehicle e : vehicle1) {
                        if (e instanceof Car) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 2:
                    System.out.println("---------- TRUCK ----------");
                    for (Vehicle e : vehicle1) {
                        if (e instanceof Truck) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    System.out.println("---------- MOTORCYCLE ----------");
                    for (Vehicle e : vehicle1) {
                        if (e instanceof Motorcycle) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 0:
                    System.out.println("---------- DISPLAY IS CLOSE ----------");
                    flag = false;
                    break;
                default:
                    System.out.println("---------- CHOICE AGAIN! ----------");
                    break;
            }
        } while (flag);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = true;
        do {
            System.out.println("---------- ADD NEW VEHICLES MENU ----------");
            System.out.println("1. Add car" + "\n" +
                    "2. Add truck" + "\n" +
                    "3. Add motorcycle" + "\n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---------- ADD NEW CAR ----------");
                    Vehicle newCar = new Car();
                    newCar.input();
                    vehicle1.add(newCar);
                    break;
                case 2:
                    System.out.println("---------- ADD NEW TRUCK ----------");
                    Vehicle newTruck = new Truck();
                    newTruck.input();
                    vehicle1.add(newTruck);
                    break;
                case 3:
                    System.out.println("---------- ADD NEW MOTORCYCLE ----------");
                    Vehicle newMotorcycle = new Motorcycle();
                    newMotorcycle.input();
                    vehicle1.add(newMotorcycle);
                    break;
                case 0:
                    System.out.println("---------- ADD NEW VEHICLES IS CLOSE ----------");
                    flag = false;
                    break;
                default:
                    System.out.println("---------- CHOICE AGAIN! ----------");
                    break;
            }
        } while (flag);
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- DELETE VEHICLE ----------");
        System.out.print("Enter license plate: ");
        String licensePlate = sc.nextLine();
        boolean flag = false;
        int choice;
        for (int i = 0; i < vehicle1.size(); i++) {
            if (licensePlate.equalsIgnoreCase(vehicle1.get(i).getLicensePlates())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            do {
                System.out.println("Do you want to delete vehicles with license plate: " + licensePlate + "?");
                System.out.println("1. Yes" + "\n" +
                        "2. No");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        for (int i = 0; i < vehicle1.size(); i++) {
                            if (licensePlate.equalsIgnoreCase(vehicle1.get(i).getLicensePlates())) {
                                vehicle1.remove(i);
                                break;
                            }
                        }
                        System.out.println("---------- DELETE SUCCESS ----------");
                        flag = false;
                        break;
                    case 2:
                        System.out.println("---------- CANCEL ----------");
                        flag = false;
                        break;
                    default:
                        System.out.println("---------- CHOICE AGAIN! ----------");
                        break;
                }
            } while (flag);
        } else {
            System.out.println("License plate " + licensePlate + " is NOT found!");
        }
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        System.out.println("---------- SEARCH VEHICLES ----------");
        System.out.print("Enter license plate: ");
        String licensePlate = sc.nextLine();

        for (int i = 0; i < vehicle1.size(); i++) {
            if (vehicle1.get(i).getLicensePlates().contains(licensePlate)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("---------- RESULT ----------");
            for (int i = 0; i < vehicle1.size(); i++) {
                if (vehicle1.get(i).getLicensePlates().contains(licensePlate)) {
                    System.out.println(vehicle1.get(i));
                }
            }
        } else {
            System.out.println("Vehicle with license plate " + licensePlate + " is NOT found!");
        }
    }
}
