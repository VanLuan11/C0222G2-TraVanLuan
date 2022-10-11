package com.example.shoponlineapi.controller;

import com.example.shoponlineapi.dto.ProductDTO;
import com.example.shoponlineapi.model.Category;
import com.example.shoponlineapi.model.OrderService;
import com.example.shoponlineapi.model.Product;
import com.example.shoponlineapi.service.ICategoryService;
import com.example.shoponlineapi.service.IOrderService;
import com.example.shoponlineapi.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(12) Pageable pageable) {

        Page<Product> productPage = productService.findAllProduct(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }

    @GetMapping("/lapTopG")
    public ResponseEntity<Page<Product>> getAllLaptopGaming(@PageableDefault(8) Pageable pageable,
                                                            Optional<String> searchNameProduct,
                                                            Optional<String> priceStart,
                                                            Optional<String> priceEnd) {
        String nameProduct = searchNameProduct.orElse("");
        String start = priceStart.orElse("0");
        String end = priceEnd.orElse("4000000000");
        Page<Product> productPage = productService.findAllLapTopGaming(pageable, nameProduct, start, end);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }

    @GetMapping("/lapTopVP")
    public ResponseEntity<Page<Product>> getAllLaptopVP(@PageableDefault(8) Pageable pageable,
                                                        Optional<String> searchNameProduct,
                                                        Optional<String> priceStart,
                                                        Optional<String> priceEnd) {

        String nameProduct = searchNameProduct.orElse("");
        String start = priceStart.orElse("0");
        String end = priceEnd.orElse("4000000000");
        Page<Product> productPage = productService.findAllLapTopVP(pageable, nameProduct, start, end);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getFeedbackById(@PathVariable int id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
        Product product = this.productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {

        List<Category> categoryList = categoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        Product product = productService.findProductById(productDTO.getId());
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
