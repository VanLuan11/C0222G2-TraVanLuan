package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"tivi",100000000.0,"tốt","lệ thị tài"));
        products.add(new Product(2,"tủ lạnh",1000000.0,"tốt","lệ thị tài"));
        products.add(new Product(3,"máy giặt",100000.0,"tốt","lệ thị tài"));
        products.add(new Product(4,"điều hoà",10000.0,"tốt","lệ thị tài"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }


}
