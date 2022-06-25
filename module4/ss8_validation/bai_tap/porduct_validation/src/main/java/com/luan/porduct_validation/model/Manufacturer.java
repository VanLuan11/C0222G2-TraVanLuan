package com.luan.porduct_validation.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameManufacture;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> productList;

    public Manufacturer() {
    }

    public Manufacturer(Integer id, String nameManufacture, List<Product> productList) {
        this.id = id;
        this.nameManufacture = nameManufacture;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
