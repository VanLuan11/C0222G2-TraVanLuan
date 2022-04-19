package ss12_java_collection_framework.bai_tap.controller;


import ss12_java_collection_framework.bai_tap.service.ProductManager;

import java.util.Scanner;

public class ProductControl {
    public void displayProduct (){
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        boolean flag = true;
        int choice;
        do {
            System.out.println("---------Menu Sản phẩm---------");
            System.out.println("1. Thêm sản phẩm\n" +
                    "2. Sửa thông tin sản phẩm theo id\n" +
                    "3. Xoá sản phẩm theo id\n" +
                    "4. Hiển thị danh sách sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên\n" +
                    "6 Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.print("Chọn chức năng bạn muốn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 :
                    productManager.add();
                    break;
                case 2 :
                    productManager.update();
                    break;
                case 3 :
                    productManager.delete();
                    break;
                case 4 :
                    productManager.display();
                    break;
                case 5 :
                    productManager.searchName();
                    break;
                case 6 :
                    productManager.sort();
                    break;
                case 0 :
                    System.out.println("Bạn đã chọn đóng Menu");
                    flag = false;
                    break;
                default :
                    System.out.println("Chọn lại");
                    break;
            }

        }while (flag);
    }
}
