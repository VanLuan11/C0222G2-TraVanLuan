package ss12_java_collection_framework.bai_tap.service;

import ss12_java_collection_framework.bai_tap.model.Product;

import java.util.*;

public class ProductManager implements IProduct {
    static Scanner scanner = new Scanner(System.in);

    static List<Product> productList = new ArrayList<>();


    static {

        Product product1 = new Product("sữa", 1, 1500);
        Product product2 = new Product("kem", 2, 5000);
        Product product3 = new Product("gạo", 3, 10000);
        Product product4 = new Product("rau", 4, 2200);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }


    @Override
    public void add() {
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhập Id sản phẩm: ");
        Integer idSanPham = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giá sản phẩm: ");
        Integer giaSanPham = Integer.parseInt(scanner.nextLine());
        Product product = new Product(tenSanPham, idSanPham, giaSanPham);
        productList.add(product);
    }

    @Override
    public void update() {
        System.out.println("-----------Thay đổi sản phẩm-----------");
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham2 = scanner.nextLine();

        boolean flag = false;
        System.out.print("Nhập id cần đổi: ");
        int id = Integer.parseInt((new Scanner(System.in).nextLine()));
        for (int i = 0; i < productList.size(); i++) {
            if (tenSanPham2 != null && productList.get(i).getId() == id) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("ID " + id + " not found!");
        }
    }

    @Override
    public void delete() {
        System.out.println("-----------Xóa sản phẩm-----------");
        System.out.print("Nhập id sản phẩm cần xóa: ");
        Integer idhang = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (idhang == productList.get(i).getId()) {
                productList.remove(i);

            }
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("-----------Danh sách sản phẩm-----------");
        for (Product list : productList) {
            System.out.println(list);
        }

    }

    @Override
    public void searchName() {
        boolean flag = false;

        System.out.println("-----------Tìm sản phẩm -----------");
        System.out.print("Nhập tên sản phẩm bạn muốn tìm: ");
        String tenHang = scanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(tenHang)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("-----------Đã tìm thấy-----------");
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().contains(tenHang)) {
                    System.out.println(productList.get(i));
                }
            }
        } else {
            System.out.println("Loại sản phẩm " + tenHang + " không tìm thấy");
        }
    }

    @Override
    public void sort() {

        System.out.println("-----------Sắp xếp sản phẩm-----------");
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getMoney() - o2.getMoney();
            }
        });
        display();

    }
}
