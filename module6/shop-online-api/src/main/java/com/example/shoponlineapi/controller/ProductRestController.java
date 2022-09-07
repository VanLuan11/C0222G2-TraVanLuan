package com.example.shoponlineapi.controller;

import com.example.shoponlineapi.model.Product;
import com.example.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(12) Pageable pageable) {
        Page<Product> productPage = productService.findAllProduct(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }
    @GetMapping("/laptopGaming")
    public ResponseEntity<List<Product>> getAllLaptopGaming() {
        List<Product> productPage = productService.findAllLaptopGaming();
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }

    @GetMapping("/laptopVanPhong")
    public ResponseEntity<List<Product>> getAllLaptopVanPhong() {
        List<Product> productPage = productService.findAllLaptopVanPhong();
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }


}
