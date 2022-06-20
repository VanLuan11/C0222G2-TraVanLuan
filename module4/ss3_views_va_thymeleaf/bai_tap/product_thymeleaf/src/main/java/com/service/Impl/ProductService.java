package com.service.Impl;

import com.model.Product;
import com.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone 2x",1000,"con"));
        productList.add(new Product(2,"Iphone xx",5000,"het"));
        productList.add(new Product(3,"Iphone 4x",1600,"con"));
        productList.add(new Product(4,"Iphone zz",1080,"het"));
    }
    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int idProduct, Product product) {
        for (int i = 0; i <productList.size() ; i++) {
            if(idProduct ==productList.get(i).getId()){
                productList.set(i,product);
                break;
            }
        }
    }

    @Override
    public void delete(int idProduct) {
        for (int i = 0; i <productList.size() ; i++) {
            if(idProduct == productList.get(i).getId() ){
                productList.remove(i);
            }
        }
    }

    @Override
    public Product findBy(int id) {
        for (Product p : productList) {
            if(id == p.getId()){
                return p;
            }

        }
        return null;
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        List<Product> list = new ArrayList<>();
        for (Product p : productList ) {
            if(nameProduct.contains(p.getName())){
                list.add(p);
            }
        }
        return list;
    }

}
