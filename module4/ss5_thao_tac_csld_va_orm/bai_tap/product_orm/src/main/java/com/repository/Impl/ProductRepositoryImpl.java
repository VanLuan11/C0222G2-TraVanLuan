package com.repository.Impl;

import com.model.Product;
import com.repository.BaseRepository;
import com.repository.IProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> getAllProduct() {

        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery
                ("select s from Product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findBy(int id) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select s" +
                        " from Product s where s.id = : productId", Product.class);
        typedQuery.setParameter("productId", id);

        return typedQuery.getSingleResult() ;
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class,id));
        entityTransaction.commit();
    }
}
