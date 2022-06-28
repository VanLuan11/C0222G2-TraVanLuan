package com.luan.porduct_validation.dto;

import com.luan.porduct_validation.model.Manufacturer;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@GroupSequence(value = {One.class,Two.class,ProductDto.class})
public class ProductDto {
    @NotEmpty(message = "không được để trống", groups = One.class)
    @NotBlank(message = "không được để rỗng", groups = Two.class)
    @Pattern(regexp =  "^(\\p{L}|\\d|,)+( (\\p{L}|\\d|,)+)*$", message = "không nhập ký tự", groups = ProductDto.class)
    private String nameProduct;

    @NotEmpty(message = "không được để trống", groups = One.class)
    @NotBlank(message = "không được để rỗng", groups = Two.class)
    @Pattern(regexp =  "^(\\p{L}|\\d|,)+( (\\p{L}|\\d|,)+)*$", message = "không nhập ký tự", groups = ProductDto.class)
    private String price;

    @NotEmpty(message = "không được để trống", groups = One.class)
    @NotBlank(message = "không được để rỗng", groups = Two.class)
    private String dateOfManufacture;

    private Manufacturer manufacturer;

    public ProductDto() {
    }

    public ProductDto(@NotEmpty(message = "không được để trống", groups = One.class) @NotBlank(message = "không được để rỗng", groups = Two.class) @Size(min = 5, max = 45, message = "Nhập đúng ký tự", groups = ProductDto.class) String nameProduct, @NotEmpty(message = "không được để trống", groups = One.class) @NotBlank(message = "không được để rỗng", groups = Two.class) String price, @NotEmpty(message = "không được để trống", groups = One.class) @NotBlank(message = "không được để rỗng", groups = Two.class) String dateOfManufacture, Manufacturer manufacturer) {
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
