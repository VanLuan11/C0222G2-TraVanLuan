package charater_stream.controller;

import charater_stream.service.StudentServiceImpl;
import ss17_io_binary_file_and_serialization.bai_tap.service.ProductServiceImpl;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    StudentServiceImpl studentService = new StudentServiceImpl();

    public void displayMenu() {

        boolean flag = true;
        int choice;
        do {
            System.out.println("----------Student---------");
            System.out.println("1.\tThêm học sinh \n" +
                    "2.\tHIển thị học sinh \n" +
                    "3.\tTìm kiếm thông tin học sinh \n" +
                    "4.\tExit\n");
            System.out.print(" Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.add();
                    break;
                case 2:
                    studentService.display();
                    break;
                case 3:
                    studentService.search();
                    break;
                case 4:
                    flag = false;
                    System.out.println("Đã thoát ");
                    break;
                default:
                    System.out.println("Mờichọn lại");
                    break;
            }
        } while (flag);
    }

}
