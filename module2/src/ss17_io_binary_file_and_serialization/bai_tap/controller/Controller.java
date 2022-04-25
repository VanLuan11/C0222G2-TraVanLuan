package ss17_io_binary_file_and_serialization.bai_tap.controller;

import ss17_io_binary_file_and_serialization.bai_tap.service.ProductServiceImpl;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    ProductServiceImpl productService = new ProductServiceImpl();

    public void displayMenu() {

        boolean flag = true;
        int choice;
        do {
            System.out.println("----------Menu Product---------");
            System.out.println("1.\tThêm sản phẩm \n" +
                    "2.\tHIển thị sản phẩm \n" +
                    "3.\tTìm kiếm thông tin sản phẩm \n" +
                    "4.\tExit\n");
            System.out.print("Mời quý khách chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.search();
                    break;
                case 4:
                    flag = false;
                    System.out.println("Quý khách đã thoát Menu");
                    break;
                default:
                    System.out.println("Mời quý khách chọn lại");
                    break;
            }
        } while (flag);
    }

}
