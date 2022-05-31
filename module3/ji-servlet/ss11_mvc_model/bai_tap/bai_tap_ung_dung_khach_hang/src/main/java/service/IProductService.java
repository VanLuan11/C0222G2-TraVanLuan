package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void save(Product product);
    void edit(Integer id, String name, Double price,String description, String producer);
    void delete( Integer id);
}
