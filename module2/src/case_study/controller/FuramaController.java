package case_study.controller;

import case_study.model.Facility;
import case_study.service.BookingServiceImpl;
import case_study.service.CustomerServiceImpl;
import case_study.service.EmployeeServiceImpl;
import case_study.service.FacilityServiceImpl;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        boolean flag = true;
        int choice;
        do {
            System.out.println("----Hệ thống quản lý khu nghỉ dưỡng Furama tại thành phố Đà Nẵng----");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.print("Mời quý khách chọng chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    displayFacilityManagement();
                    break;
                case 4:
                    displayBookingManagement();
                    break;
                case 5:
                    displayPromotionManagement();
                    break;
                case 6:
                    flag = false;
                    break;

                default:
                    System.out.println("Mời quá khách chọn lại");
                    break;
            }
        } while (flag);
    }

    public void displayEmployeeManagement() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean flag = true;
        int choice;
        do {
            System.out.println("---- Employee Management----");
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            System.out.print("Mời quý khách chọng chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }

    public void displayCustomerManagement() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean flag = true;
        int choice;
        do {
            System.out.println("---- Customer Management----");
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            System.out.print("Mời quý khách chọng chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }

    public void displayFacilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean flag = true;
        int choice;
        do {
            System.out.println("---- Facility Management----");
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            System.out.println("Mời quý khách chọng chức năng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    displayAddNewFacility();
                    break;
                case 3:
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }

    public void displayAddNewFacility() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean flag = true;
        int choice;
        do {
            System.out.println("---- ADD NEW FACILITY ----");
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n");
            System.out.print("Mời quý khách chọng chức năng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    facilityService.addVilla();
                    break;
                case 2:
                    facilityService.addHouse();
                    break;
                case 3:
                    facilityService.addRoom();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }

    public void displayBookingManagement() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        boolean flag = true;
        int choice;
        do {
            System.out.println("----Booking Management----");
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n");
            System.out.println("Mời quý khách chọng chức năng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookingService.display();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }

    public void displayPromotionManagement() {
        boolean flag = true;
        int choice;
        do {
            System.out.println("---- Promotion Management----");
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");
            System.out.println("Mời quý khách chọng chức năng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("");
            }
        } while (flag);
    }
}
