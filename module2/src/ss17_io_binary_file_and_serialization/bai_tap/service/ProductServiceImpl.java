package ss17_io_binary_file_and_serialization.bai_tap.service;

import ss17_io_binary_file_and_serialization.bai_tap.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements IProductService {
    Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();
    static List<ProductFile> productFileList = new ArrayList<>();

    static {
        productList.add(new Product(1, "TiVi", "TàiProduct", 1000));
        productList.add(new Product(2, "Tủ Lạnh", "HoànProduct", 2000));
        productList.add(new Product(3, "Điều Hòa", "PhươngProduct", 3000));
        ProductFile.witerFile(productList);
    }


    @Override
    public void add() {
        System.out.println("----------Thêm mới sản phẩm----------");
        System.out.println("Thêm mới id sản phẩm: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm mới tên sản phẩm: ");
        String ten = scanner.nextLine();
        System.out.println("Thêm mới hãng sản phẩm: ");
        String hang = scanner.nextLine();
        System.out.println("Thêm mới giá sản phẩm: ");
        Integer gia = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, ten, hang, gia);
        productList.add(product);
        ProductFile.witerFile(productList);
    }

    @Override
    public void display() {
        List<Product> productFileList = ProductFile.readFile();
        for (Product a : productFileList) {
            System.out.println(a);
        }
    }

    @Override
    public void search() {
        boolean flag = false;
        while (true) {
            System.out.println("---------Tìm kiếm sản phẩm----------");
            System.out.print("Nhập id sản phẩm bạn muốn tìm kiếm: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getCodeProduct() == id) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("---------Đã tìm thấy sản phẩm---------");
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getCodeProduct() == id) {
                        System.out.println(productList.get(i));
                        return;
                    }
                }
            } else {
                System.out.println("---------Không tìm thấy sản phẩm----------");
                System.out.println("Id sản phẩm: " + id + " không tìm thấy");
                return;
            }
        }
    }
}
