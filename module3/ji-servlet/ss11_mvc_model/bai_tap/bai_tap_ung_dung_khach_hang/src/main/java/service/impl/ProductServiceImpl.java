package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository iProductRepository = new ProductRepositoryImpl();
    private List<Product> products = this.iProductRepository.getAll();
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void edit(Integer id, String name, Double price, String description, String producer) {
        for (Product p : products ){
            if(p.getId()==id){
                p.setId(id);
                p.setName(name);
                p.setPrice(price);
                p.setDescription(description);
                p.setProducer(producer);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        for (Product p: products) {
            if(p.getId()==id){
                iProductRepository.delete(p);
                break;
            }
        }
    }
}
