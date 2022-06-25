package com.luan.porduct_validation.controller;

import com.luan.porduct_validation.dto.ProductDto;
import com.luan.porduct_validation.model.Product;
import com.luan.porduct_validation.service.IManufacturerService;
import com.luan.porduct_validation.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IManufacturerService manufacturerService;

    @GetMapping("")
    public String showProduct(Model model){
        model.addAttribute("listProduct", productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute @Valid ProductDto productDto,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("product", productDto);
            return "/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        this.productService.save(product);
        return "redirect:product/";
    }
    @GetMapping("{id}/edit")
    public String showCreate(@PathVariable int id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("listManufacturer", manufacturerService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String getCreate(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product/";
    }
    @GetMapping("{id}/delete")
    public String getCreate(@PathVariable int id,Model model){
        model.addAttribute("product", productService.getProduct(id));
        productService.delete(id);
        return "redirect:/product/";
    }
}
