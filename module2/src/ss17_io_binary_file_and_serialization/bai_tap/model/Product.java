package ss17_io_binary_file_and_serialization.bai_tap.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer codeProduct;
    private String nameProduct;
    private String productCompany;
    private Integer price;

    public Product() {
    }

    public Product(Integer codeProduct, String nameProduct, String productCompany, Integer price) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.productCompany = productCompany;
        this.price = price;
    }

    public Integer getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Integer codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product" +
                "codeProduct: " + codeProduct +
                ", nameProduct: " + nameProduct +
                ", productCompany: " + productCompany +
                ", price: " + price;
    }
}
