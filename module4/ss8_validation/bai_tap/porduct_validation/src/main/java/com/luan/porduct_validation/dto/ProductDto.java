package com.luan.porduct_validation.dto;

import com.luan.porduct_validation.model.Manufacturer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductDto {
    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45, message = "Nhập đúng ký tự")
    private String nameProduct;

    @NotEmpty
    @NotBlank
    @Size(min = 1, message = "Giá ko đc nhỏ hơn 0")
    private String price;

    @NotEmpty
    @NotBlank
    @DateTimeFormat
    private String dateOfManufacture;

    private Manufacturer manufacturer;

    public ProductDto() {
    }

    public ProductDto(@NotEmpty @NotBlank @Size(min = 5, max = 45, message = "Nhập đúng ký tự") String nameProduct, @NotEmpty @NotBlank @Size(min = 1, message = "Giá ko đc nhỏ hơn 0") String price, @NotEmpty @NotBlank String dateOfManufacture, Manufacturer manufacturer) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.manufacturer = manufacturer;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
